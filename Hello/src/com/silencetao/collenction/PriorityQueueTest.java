package com.silencetao.collenction;

import java.util.PriorityQueue;

/**
 * PriorityQueue Test
 * @author Silence
 * create time 2017��11��16�� ����5:21:10
 * @version 1.0.1
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        System.out.println(pq);
        System.out.println(pq.poll());
    }
}
