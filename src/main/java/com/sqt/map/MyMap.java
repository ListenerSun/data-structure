package com.sqt.map;

import java.util.Map;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-15 23:58
 */
public interface MyMap<K,V> {

    /**集合大小
     * @return
     */
    int size();

    /**获取某个元素
     * @param k
     * @return
     */
    V get(K k);

    /**是否包含某个元素
     * @param k
     * @return
     */
    Boolean  contains(K k);

    /**添加元素
     * @param k
     * @param v
     * @return
     */
    V put(K k,V v);

    /**删除某个元素
     * @param k
     * @return
     */
    V remove(K k);

}
