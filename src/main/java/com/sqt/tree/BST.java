package com.sqt.tree;

/**
 * @Description: 二分搜索树
 * 元素具有可比性
 * 添加重复元素时不做任何操作
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2019-12-26 0:11
 */
public class BST<E extends Comparable<E>> {

    /**
     * 元素个数
     */
    int size;
    /**
     * 根节点
     */
    Node root;

    public BST(int size) {
        this.size = size;
        this.root = null;
    }

    /**
     * add a Element
     *
     * @param e
     * @return
     */
    public void add(E e) {
        add(root, e);
    }

    /**
     * add 递归函数
     *
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        //递归终止条件
        if (null == node) {
            node = new Node(e);
            size++;
            return node;
        }
        //调用递归
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (node.e.equals(e)) {
            return node;
        } else {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     *
     */
    private class Node {
        E e;
        Node right, left;

        public Node(E e) {
            this.e = e;
            right = null;
            left = null;
        }
    }
}
