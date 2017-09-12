package com.silencetao.net.udp.chatroom;

import java.text.DateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * 
 * @author Silence
 * create time 2017年7月31日 下午1:10:24
 * @version 1.0.1
 */
public class LanTalk extends JFrame {
    private DefaultListModel<User> listModel = new DefaultListModel<>();
    private JList<User> friendsList = new JList<>();
    private DateFormat format = DateFormat.getDateInstance();
    
    public LanTalk() {
        super("局域网聊天");
    }
}
