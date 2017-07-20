package com.silencetao.net;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ���߳����ع�����
 * @author Silence
 *
 */
public class DownUtils {
    //����������Դ��·��
    private String path;
    //ָ�������ص��ļ��ı���λ��
    private String targetFile;
    //������Ҫʹ�ö��ٸ��߳�������Դ
    private int threadNum;
    //�������ص��̶߳���
    private DownThread[] threads;
    //�������ص��ļ��ܴ�С
    private int fileSize;
    
    public DownUtils(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        //��ʼ��threads����
        threads = new DownThread[threadNum];
    }
    
    public void download() throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept",
                "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                + "application/x-shockwave-flash, application/xaml+xml, "
                + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                + "application/x-ms-application, application/vnd.ms-excel, "
                + "application/vnd.ms-powerpoint, application/msword, */*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "keep-Alive");
        //�õ��ļ���С
        fileSize = conn.getContentLength();
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        //���ñ����ļ��Ĵ�С
        file.setLength(fileSize);
        file.close();
        DownRate downRate = new DownRate(fileSize);
        for (int i = 0; i < threadNum; i++) {
            //����ÿ���߳����صĿ�ʼλ��
            int startPos = i * currentPartSize;
            //ÿ���߳�ʹ��һ��RandomAccessFile��������
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            //��λ���̵߳���������
            currentPart.seek(startPos);
            //���������߳�
            threads[i] = new DownThread(startPos, currentPartSize, currentPart, downRate);
            //���������߳�
            threads[i].start();
        }
    }
    
    public double getCompleteRate() {
        //ͳ�ƶ���߳��Ѿ����ص��ܴ�С
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        return sumSize * 1.0 / fileSize;
    }
    
    private class DownRate {
        //�������ص��ļ��ܴ�С
        private int fileSize;
        //���嵱ǰ�����ص����ֽ���
        private int total;
        
        public DownRate(int fileSize) {
            this.fileSize = fileSize;
            this.total = 0;
        }
        
        public synchronized void calculateRate(int length) {
            total += length;
            if (total > 0) {
                double rate = total * 1.0 / fileSize;
                if (rate < 1) {
                    System.out.println("������:" + String.format("%.2f", rate * 100) + "%");
                } else {
                    System.out.println("������:100%");
                    System.out.println("�������");
                }
            }
        }
    }
    
    private class DownThread extends Thread {
        //��ǰ�̵߳�����λ��
        private int startPos;
        //���嵱ǰ�̸߳������ص��ļ���С
        private int currentPartSize;
        //��ǰ�߳���Ҫ���ص��ļ���
        private RandomAccessFile currentPart;
        //������߳������ص��ֽ���
        public int length;
        //����������ؽ��ȵ���
        private DownRate downRate;
        
        public DownThread(int startPos, int currentPartSize,
                RandomAccessFile currentPart, DownRate downRate) {
            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;
            this.downRate = downRate;
        }
        
        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept",
                        "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                        + "application/x-shockwave-flash, application/xaml+xml, "
                        + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                        + "application/x-ms-application, application/vnd.ms-excel, "
                        + "application/vnd.ms-powerpoint, application/msword, */*");
                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = conn.getInputStream();
                //����startPos���ֽڣ������߳�ֵ�����Լ�������ǲ����ļ�
                inStream.skip(startPos);
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                //��ȡ��·���ݣ���д�뱾���ļ�
                while (length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {
                    currentPart.write(buffer, 0, hasRead);
                    //�ۼƸ��߳����ص��ܴ�С
                    length += hasRead;
                    downRate.calculateRate(hasRead);
                }
                currentPart.close();
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
