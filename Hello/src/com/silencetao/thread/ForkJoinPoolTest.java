package com.silencetao.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * �̳�RecursiveAction��ʵ��"�ɷֽ�"������
 * @author Silence
 * create time 2017��11��14�� ����5:39:28
 * @version 1.0.1
 */
class PrintTaskPlus extends RecursiveAction {
    
    /**
     * ÿ��С��������ӡ50����
     */
    private static final int THRESHOLD = 50;
    private int start;
    private int end;
    
    public PrintTaskPlus(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "��iֵ:" + i);
            }
        } else {
            //��end��start֮��Ĳ����THRESHOLD����Ҫ��ӡ����������50��ʱ
            //��������ֽ������С����
            int middle = (start + end) / 2;
            PrintTaskPlus left = new PrintTaskPlus(start, middle);
            PrintTaskPlus right = new PrintTaskPlus(end, middle);
            //����ִ������С����
            left.fork();
            right.fork();
        }
    }
}

/**
 * ForkJoinPool����
 * @author Silence
 * create time 2017��11��14�� ����5:37:48
 * @version 1.0.1
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        //�ύ�ɷֽ��PrintTask����
        pool.submit(new PrintTaskPlus(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        //�ر��̳߳�
        pool.shutdown();
    }
}
