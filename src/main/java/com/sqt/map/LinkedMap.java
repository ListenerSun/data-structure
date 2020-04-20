package com.sqt.map;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2020-04-15 23:57
 */
public class LinkedMap<K,V> implements MyMap<K,V> {


    private int size;
    private Node dummyHead;

    public LinkedMap() {
        this.size = 0;
        this.dummyHead = new Node();
    }


    public int size() {
        return this.size;
    }

    /**
     * @param k
     * @return
     */
    public V get(K k){
        Node node = getNode(k);
        return node == null ? null : node.v;
    }

    public Boolean contains(K k) {
        return null != getNode(k);
    }

    public V put(K k, V v) {
        Node node = getNode(k);
        if (null != node){
            node.v = v;
        }else{
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
        }

        return v;
    }

    public V remove(K k) {
        Node cur = dummyHead;
        while (cur.next != null){
            if (cur.next.k.equals(k)){
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null){
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }
        return null;
    }


    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.k.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        while(dummyHead.next != null){

        }
        return dummyHead.toString();
    }

    private class Node{
        public K k;
        public V v;
        public Node next;

        public Node(K key, V value, Node next){
            this.k = key;
            this.v = value;
            this.next = next;
        }

        public Node(K key, V value){
            this(key, value, null);
        }

        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString(){
            return k.toString() + " : " + v.toString();
        }
    }

    public static void main(String[] args) {
        LinkedMap<String,Integer> map = new LinkedMap<String, Integer>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        System.out.println("size:"+map.size);
        System.out.println("map contains 1:"+map.contains("1"));
    }
}
