package com.sqt.queen;

/**
 * @Description: 循环队列
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-20  0:13
 */
public class LoopQueen<E> implements Queen<E> {
    //队列内元素的个数
    private int size;
    //队列首元素索引位置
    private int front;
    //队列末尾元素索引位置
    private int tail;

    private E[] data;

    public LoopQueen(int capacity) {
        this.size = size;
        this.front = 0;
        this.tail = 0;
        this.data = (E[]) new Object[capacity+1];
    }

    /**
     * 默认队列元素的容积为10
     */
    public LoopQueen() {
        this(10);
    }

    /**获取队列内的元素个数
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**入队
     * @param e
     */
    public void enqueen(E e) {

        if ((tail+1)%data.length == front){  //队列满了需要扩容
            resize(2*data.length);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    /**队列容积的动态扩展
     * @param capacity
     */
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity+1];
        for (int i = 0; i < size; i++) {
          newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**出队
     * @return
     */
    public E dequeen() {
        if (isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列内的元素个数为0");
        }
        return data[front];
    }
}
