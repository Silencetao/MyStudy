package com.silencetao.reflect.aop;

/**
 * 
 * @author Silence
 * create time 2017��12��5�� ����3:23:04
 * @version 1.0.1
 */
public class GunDog implements Dog {

    @Override
    public void info() {
        System.out.println("����һֻ����");
    }

    @Override
    public void run() {
        System.out.println("�һ���Ծ�뱼��");
    }

}
