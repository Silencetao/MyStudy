package com.silencetao.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 继承RecursiveAction来实现"可分解"的任务
 * @author Silence
 * create time 2017年11月14日 下午5:39:28
 * @version 1.0.1
 */
class PrintTaskPlus extends RecursiveAction {
    
    /**
     * 每个小任务最多打印50个数
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
                System.out.println(Thread.currentThread().getName() + "的i值:" + i);
            }
        } else {
            //当end与start之间的差大于THRESHOLD，即要打印的数超过了50个时
            //将大任务分解成两个小任务
            int middle = (start + end) / 2;
            PrintTaskPlus left = new PrintTaskPlus(start, middle);
            PrintTaskPlus right = new PrintTaskPlus(end, middle);
            //并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}

/**
 * ForkJoinPool测试
 * @author Silence
 * create time 2017年11月14日 下午5:37:48
 * @version 1.0.1
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        //提交可分解的PrintTask任务
        pool.submit(new PrintTaskPlus(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        //关闭线程池
        pool.shutdown();
    }
}
