package com.silencetao.thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 继承RecursiveTask来实现可分解的任务
 * @author Silence
 *
 */

class CalTask extends RecursiveTask<Integer> {
    //每个小任务最多只累加20个数
    private static final int THRESHOLD = 20;
    private int arr[];
    private int start;
    private int end;

    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
       int sum = 0;
       if (end - start < THRESHOLD) {
           for (int i = start; i < end; i++) {
               sum += arr[i];
           }
           return sum;
       } else {
           int middle = (start + end) / 2;
           CalTask left = new CalTask(arr, start, middle);
           CalTask right = new CalTask(arr, middle, end);
           left.fork();
           right.fork();
           //把两个小任务累加的结果合并起来
           return left.join() + right.join();
       }
    }
    
}

public class SumTask {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[100];
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = random.nextInt(20);
            total += (arr[i] = temp);
        }
        System.out.println(total);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
        System.out.println(future.get());
        pool.shutdown();
    }

}
