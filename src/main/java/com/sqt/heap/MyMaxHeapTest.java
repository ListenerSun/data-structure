package com.sqt.heap;

import com.sqt.test.MaxHeap;

import java.util.Random;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-24 0:00
 */
public class MyMaxHeapTest {
    public static void main(String[] args) {
        MyMaxHeap<Integer> heap = new MyMaxHeap();
        int count = 20;
        for (int i = 0; i < count; i++) {
          heap.add(new Random().nextInt(100));
        }
        int[] arr = new int[count];
        for(int i = 0 ; i < count ; i ++) {
            System.out.println(heap.extractMax());
        }

        for(int i = 1 ; i < count ; i ++) {
            if(arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
    }
}
