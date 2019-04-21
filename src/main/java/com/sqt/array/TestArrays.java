package com.sqt.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-15  23:28
 */
public class TestArrays {
    public static void main(String[] args) {
        Arrays<Integer> arr = new Arrays<Integer>(2);
        System.out.println("数组的长度："+arr.getLength()+"  数组内的元素个数:"+arr.getSize());
        //添加元素时，超过数组当前长度，数组自动扩容
        for (int i = 0; i < 2; i++){
            arr.add(i,i);
        }
//        System.out.println(arr.contains(1));
//        System.out.println("数组的长度："+arr.getLength()+"  数组内的元素个数:"+arr.getSize());
//        //移除一个元素，数组长度没有立即缩小实现了Lazy效果
//        arr.remove(0);
//        System.out.println("数组的长度："+arr.getLength()+"  数组内的元素个数:"+arr.getSize());
//
         arr.remove(0);


        System.out.println("数组的长度："+arr.getLength()+"  数组内的元素个数:"+arr.getSize());
    }
}
