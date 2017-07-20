package com.silencetao.net;

/**
 * 执行下载
 * @author Silence
 *
 */
public class MultiThreadDown {

    public static void main(String[] args) throws Exception {
        //初始化DownUtils对象
        final DownUtils downUtils = new DownUtils("https://www.silencetao.com/silenceUpload/img/history/149408562421192079088.png", 
                "net/down05.png", 4);
        //开始下载
        downUtils.download();
    }
}
