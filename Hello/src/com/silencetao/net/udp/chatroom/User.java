package com.silencetao.net.udp.chatroom;

import java.net.SocketAddress;

/**
 * 聊天室用户类
 * @author Silence
 * create time 2017年7月27日 下午12:22:24
 * @version 1.0.1
 */
public class User {
    
    /**
     * 用户图标
     */
    private String icon;
    
    /**
     * 用户名
     */
    private String name;
    
    /**
     * 该用户所在MulticastSocket所在的IP地址和端口
     */
    private SocketAddress address;
    
    /**
     * 该用户失去联系的次数
     */
    private int lost;
    
    public User() {}

    public User(String icon, String name, SocketAddress address, int lost) {
        this.icon = icon;
        this.name = name;
        this.address = address;
        this.lost = lost;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocketAddress getAddress() {
        return address;
    }

    public void setAddress(SocketAddress address) {
        this.address = address;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }    
}
