package com.silencetao.net;

/**
 * ִ������
 * @author Silence
 *
 */
public class MultiThreadDown {

    public static void main(String[] args) throws Exception {
        //��ʼ��DownUtils����
        final DownUtils downUtils = new DownUtils("https://www.silencetao.com/silenceUpload/img/history/149408562421192079088.png", 
                "net/down05.png", 4);
        //��ʼ����
        downUtils.download();
    }
}
