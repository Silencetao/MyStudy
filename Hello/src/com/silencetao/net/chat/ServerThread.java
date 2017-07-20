package com.silencetao.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 服务端线程处理类
 * @author Silence
 * create time 2017年7月20日 下午2:40:55
 * @version 1.0.1
 */
public class ServerThread extends Thread {
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;
    
    //定义一个构造器，用于接收一个Socket来创建ServerThread线程
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        System.out.println("有小伙伴加入了服务器");
        try {
            //获取该Socket对应的输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取该socket对应的输出流
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br.readLine()) != null) {
                //如果读到的行以CrazyitProtocol.USER_ROUND开始
                //并以其结束则可以确定读到的是用户登陆的用户名
                if (line.startsWith(CrazyitProtocol.USER_ROUND) &&
                        line.endsWith(CrazyitProtocol.USER_ROUND)) {
                    //得到真是消息
                    String userName = getRealMsg(line);
                    if (Server.clients.map.containsKey(userName)) {
                        System.out.println("重复");
                        ps.println(CrazyitProtocol.NAME_REP);
                    } else {
                        System.out.println("成功");
                        ps.println(CrazyitProtocol.LOGIN_SUCCESS);
                        Server.clients.put(userName, ps);
                    }
                } 
                //如果读到的行以CrazyitProtocol.PRIVATE_ROUND开始
                //并以其结束则可以确定是私聊信息，私聊信息只是向特定的输出流发送
                else if (line.startsWith(CrazyitProtocol.PRIVATE_ROUND) && 
                        line.endsWith(CrazyitProtocol.PRIVATE_ROUND)) {
                    //得到真消息
                    String userAdnMsg = getRealMsg(line);
                    //以SPLIT_SIGN分隔字符串，前半是私聊用户，后半是聊天信息
                    String user = userAdnMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
                    String msg = userAdnMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
                    //获取私聊用户对应的输出流，并发送私聊信息
                    Server.clients.map.get(user).println(
                            Server.clients.getKeyByValue(ps)
                            + "对你说:" + msg);
                }
                //公聊要向每个Socket发送
                else {
                    //得到真实消息
                    String msg = getRealMsg(line);
                    //遍历clients中的每个输出流
                    for (PrintStream clientPs : Server.clients.valueSet()) {
                        clientPs.println(Server.clients.getKeyByValue(ps) + "说:" + msg);
                    }
                }
            }
        }
        //捕获到异常后，表明该Socket对应的客户端已经出现了问题
        //所以程序将其对应的输出流从Map中删除
        catch (IOException e) {
            System.out.println("有小伙伴离开了服务器");
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.map.size());
            //关闭网络，IO资源
            try {
                if (br != null) {
                    br.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    //将读到的内容去掉前后的协议字符，恢复成真是数据
    private String getRealMsg(String line) {
        return line.substring(CrazyitProtocol.PROTOCOL_LEN, line.length() - CrazyitProtocol.PROTOCOL_LEN);
    }
}
