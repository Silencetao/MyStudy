package com.silencetao.net.chat;

/**
 * 用于定义协议的字符
 * @author Silence
 * create time 2017年7月20日 下午2:02:54
 * @version 1.0.1
 */
public interface CrazyitProtocol {
    //定义协议字符串的长度
    int PROTOCOL_LEN = 1;
    //下面是一些协议字符串，服务器和客户端交换的信息都
    //应该在前、后添加这种特殊字符串
    String MSG_ROUND = "△";
    String USER_ROUND = "☆";
    String LOGIN_SUCCESS = "♥";
    String NAME_REP = "♣";
    String PRIVATE_ROUND = "♠";
    String SPLIT_SIGN = "★";
}
