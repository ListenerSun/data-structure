package com.sqt.heap;

/**
 * @Description: 实现一个动态数组, 该数组内的元素是连续的不允许中间有空位
 * @author: sqt(男 ， 未婚) 微信:810548252
 * @Date: Created in 2019-04-15  23:08
 */
public class Array<E> {

    private E[] data;
    //数组内元素的个数
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 向某个索引位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("failed add,required index < array.length and index > 0");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 移除某个位置的元素
     *
     * @param index
     */
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("failed remove,required index < array.length and index > 0");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //当size = data.length/4才对数组进行缩小，实现了一个Lazy的效果,防止出现极端的O(n)复杂度情况
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
    }

    /**
     * 数组扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //向数组内的开始插入元素
    public void addFirst(E e) {
        add(0, e);
    }

    //向数组内末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取制定位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed,Index is illegal");
        }
        return data[index];
    }

    //修改制定位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed,Index is illegal");
        }
        data[index] = e;
    }

    //判断数组内是否包含某个元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //获取数组内的元素个数
    public int getSize() {
        return this.size;
    }

    //获取数组的容量
    public int getLength() {
        return this.data.length;
    }

    /** 交换 两个索引 值
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= data.length || j < 0 || j >= data.length) {
            throw new IllegalArgumentException(" index out of ");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
