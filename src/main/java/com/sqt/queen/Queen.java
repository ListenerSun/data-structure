package com.sqt.queen;

/**
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-04-19  22:04
 */
public interface Queen<E> {

    int getSize();
    //入队
    void enqueen(E e);
    //出队
    E  dequeen();
    //判断队列是否为空
    Boolean isEmpty();
    //获取队首的元素
    E getFront();

}
