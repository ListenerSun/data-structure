package com.sqt.linkedlist;

/**
 * @Description: 自定义一个链表
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-05-26  23:30
 */
public class LinkedList<E> {

    private Node dummyHead;
    private int size;

    public LinkedList(Node dummyHead, int size) {
        this.dummyHead = new Node();
        this.size = 0;
    }
    //向链表头部添加一个元素
    public void add(E e){
        addFirst(e,0);
    }

    public void addFirst(E e,int index){
        Node cur = new Node(e,dummyHead.next);
        dummyHead.next = cur;
        size++;
    }

    /**向链表
     * @param e
     */
    public void remove(E e){

    }

    private class Node{
        public E e;
        private Node next;
        private Node preve;

        public Node() {
        }

        public Node(E e, Node next, Node preve) {
            this.e = e;
            this.next = next;
            this.preve = preve;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
}
