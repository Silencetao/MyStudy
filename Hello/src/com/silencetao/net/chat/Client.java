package com.silencetao.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 客户端程序
 * @author Silence
 * create time 2017年7月20日 下午3:54:02
 * @version 1.0.1
 */
public class Client {
    private static final int SERVER_PORT = 30000;
    private Socket socket;
    private PrintStream ps;
    private BufferedReader brServer;
    private BufferedReader keyIn;
    
    public void init() {
        try {
            keyIn = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket("127.0.0.1", SERVER_PORT);
            ps = new PrintStream(socket.getOutputStream());
            brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String tip = "";
            while (true) {
                String userName = JOptionPane.showInputDialog(tip + "输入用户名");
                ps.println(CrazyitProtocol.USER_ROUND + userName + CrazyitProtocol.USER_ROUND);
                String result = brServer.readLine();
                if (result.equals(CrazyitProtocol.NAME_REP)) {
                    tip = "用户名重复";
                    continue ;
                }
                if (result.equals(CrazyitProtocol.LOGIN_SUCCESS)) {
                    break ;
                }
            }
        } catch (Exception e) {
            closeRs();
        }
        new ClientThread(brServer).start();
    }
    
    public void readAndSend() {
        try {
            String line = null;
            while ((line = keyIn.readLine()) != null) {
                //如果发送的信息中有冒号，且以//开头，则认为想发送私聊信息
                if (line.indexOf(":") > 0 && line.startsWith("//")) {
                    line = line.substring(2);
                    ps.println(CrazyitProtocol.PRIVATE_ROUND + line.split(":")[0] + CrazyitProtocol.SPLIT_SIGN +  
                            line.split(":")[1] + CrazyitProtocol.PRIVATE_ROUND);
                } else {
                    ps.println(CrazyitProtocol.MSG_ROUND + line + CrazyitProtocol.MSG_ROUND);
                }
            }
        } catch (IOException e) {
            closeRs();
        }
    }
    
    private void closeRs() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (brServer != null) {
                brServer.close();
            }
            if (keyIn != null) {
                keyIn.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Client client = new Client();
        client.init();
        client.readAndSend();
    }
}
