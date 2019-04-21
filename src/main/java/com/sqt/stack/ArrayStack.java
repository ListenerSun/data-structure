package com.sqt.stack;

/**
 * @Description: 数组实现栈
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-18  0:06
 */
public class ArrayStack<E> implements Stack<E> {

    private Arrays<E> arrays;

    public ArrayStack(int capacity) {
        this.arrays = new Arrays<E>(capacity);
    }

    public ArrayStack() {
    }

    public void pop() {
        arrays.removeLast();
    }

    public void push(E e) {
        arrays.addLast(e);
    }

    public E peek() {
        return arrays.getLast();
    }

    public Boolean isEmpty() {
        return this.arrays.isEmpty();
    }

    /**获取栈内的元素个数
     * @return
     */
    public int getSize() {
        return this.arrays.getSize();
    }

    /**获取栈的容量
     * @return
     */
    public int getCapacity(){
        return this.arrays.getLength();
    }
}
