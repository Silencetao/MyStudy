package com.silencetao.reflect.aop;

/**
 * 
 * @author Silence
 * create time 2017年12月5日 下午3:23:04
 * @version 1.0.1
 */
public class GunDog implements Dog {

    @Override
    public void info() {
        System.out.println("我是一只狗子");
    }

    @Override
    public void run() {
        System.out.println("我会跳跃与奔驰");
    }

}
