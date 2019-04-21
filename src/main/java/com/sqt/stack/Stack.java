package com.sqt.stack;

/**
 * @Description: 栈接口
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-18  0:00
 */
public interface Stack<E> {
    //出栈
    void pop();
    //入栈
    void push(E e);
    //查看栈顶元素
    E peek();
    //判断栈是否为空
    Boolean isEmpty();
    //查看栈内的元素
    int getSize();



}
