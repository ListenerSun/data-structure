package com.sqt.queen;


/** 使用数组实现队列
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-19  23:32
 */
public class ArrayQueen<E> implements Queen<E> {

    private Arrays<E> arrays;

    public ArrayQueen(int capacity) {
        this.arrays = new Arrays<E>(capacity);
    }

    public ArrayQueen() {
        arrays = new Arrays();
    }

    public int getSize() {
        return this.arrays.getSize();
    }


    public void enqueen(E e) {
        this.arrays.addLast(e);
    }

    public E dequeen() {
        return this.arrays.removeFirst();
    }

    public Boolean isEmpty() {
        return this.arrays.isEmpty();
    }

    public E getFront() {
        return this.arrays.getFirst();
    }
}
