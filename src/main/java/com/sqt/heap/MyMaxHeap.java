package com.sqt.heap;


/**
 * @Description: 自己实现最大堆
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-23 22:45
 */
public class MyMaxHeap<E extends Comparable> {

    public static final int MAX_INDEX = 0;

    private Array<E> data;

    public MyMaxHeap() {
        this.data = new Array<E>();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * get size of this heap
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * @param e
     * @return
     */
    public void add(E e) {
        data.addLast(e);
        swiftUp(data.getSize() - 1);
    }

    /** 取出最大元素
     * @return
     */
    public E extractMax() {
        E max = findMax();
        data.swap(MAX_INDEX,data.getSize()-1);
        data.remove(data.getSize()-1);
        swiftDown(MAX_INDEX);
        return max;
    }



    public E findMax() {
        return data.get(MAX_INDEX);
    }

    /** 上升
     * @param index
     */
    private void swiftUp(int index) {
        while (index > 0 && data.get(getParentIndex(index)).compareTo(data.get(index)) < 0) {
            data.swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * 下降
     */
    private void swiftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int tempIndex = leftChild(index);
            if (tempIndex+1 < data.getSize() &&
                    data.get(tempIndex).compareTo(data.get(tempIndex+1)) < 0 ) {
                tempIndex++;
            }
            if (data.get(index).compareTo(data.get(tempIndex)) >= 0) {
                break;
            }
            data.swap(index,tempIndex);
            index = tempIndex;
        }
    }

    /**
     * 得到 左子节点 的索引值
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * get 右子节点 的索引值
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * get 父节点 索引值
     */
    private int getParentIndex(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

}
