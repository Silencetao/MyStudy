package com.silencetao.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * ForkJoinPool����
 * �̳�RecursiveAction��ʵ�ֿɷֽ������
 * @author Silence
 *
 */
public class PrintTask extends RecursiveAction {
    //ÿ��С��������ӡ50����
    private static final int THRESHOLD = 50;
    private int start;
    private int end;
    
    //��ӡ��start��end������
    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        //��end��start֮��Ĳ�С��THRESHOLDʱ����ʼ��ӡ
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "----->" + i);
            }
        } else {
            //��end��start֮��Ĳ����THRESHOLD����Ҫ��ӡ��������50��ʱ
            //��������ֽ������С����
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            //����ִ������С����
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        //�ύ�ɷֽ��PrintTask����
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        //�ر��̳߳�
        pool.shutdown();
    }
}
