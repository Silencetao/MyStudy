package com.silencetao.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ�ɾ������
 * @author Silence
 * create time 2017��7��26�� ����3:02:08
 * @version 1.0.1
 */
public class FileDelete {

    public static void main(String[] args) throws IOException {
        File file = new File("E:/Code/eclipse/caf-template-admin/src/main/webapp/upload/253aea26-7558-4f4b-8c39-3511e94e8c5f.jpg");
        System.out.println(file.exists());
        FileOutputStream fos = new FileOutputStream(file);
//        fos.write("Hello world!".getBytes());
    }
}
