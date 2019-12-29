package com.sqt.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public BST() {

    }

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
        root = add(root, e);
    }

    /**判断 二分搜索树是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取二分搜索树中元素的个数
     */
    public int size(){
        return size;
    }

    /**
     * add 递归函数 返回新增元素后二分搜索书的根
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
     * Is Contains an Element
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        //不包含
        if (null == node) {
            return false;
        }
        //递归调用
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 深度优先遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //前序遍历
//        System.out.println(node.e);
        preOrder(node.left);
        //中序遍历
//        System.out.println(node.e);
        preOrder(node.right);
        //后序遍历
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.e);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

    }

    /**
     * 查找最大元素
     *
     * @return
     */
    public E getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root).e;
    }

    /**查找以 node 为根节点二分搜索树中的最大值的节点，并返回最大节点
     * @param node
     * @return
     */
    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 删除最大的元素，并返回删除的元素值
     */
    public E deleteMax() {
        E max = getMax();
        root = removeMax(root);
        return max;

    }

    /**
     * 删除最大元素，返回删除后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node == null) {
            return null;
        }
        // 此时  node 就是最大的元素，将node左子树的根返回；
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意一个元素
     * @param e
     */
    public void deleteNode(E e){
        if (root == null){
            throw new IllegalArgumentException("BST is null!");
        }
        root = deleteNode(root,e);
    }

    /** 删除以 node 为根的二分搜索树中 e 的节点,递归算法
     *  返回删除元素后新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node deleteNode(Node node, E e) {
        if (node == null){
            System.out.println("No an Element in BST ！");
            return null;
        }
        // e 元素在 node 的右子树中
        if (e.compareTo(node.e) > 0){
            node.right = deleteNode(node.right,e);
            return node;
        }else if (e.compareTo(node.e) < 0){ // e 元素在 node 的左子树中
            node.left = deleteNode(node.left,e);
            return node;
        }else {
            //此时 node.e == e,需要将 node 节点移除掉
            if (node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }else if (node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }else{
                // node 左右子树都不为空
                // 找到比待删除节点大的最小值,即待删除节点右子树中的最小值或者待删除节点左树的最大值
                // 用这个节点代替待删除接节点

                //先定义一个返回值获取左子树中的最大节点
                Node successCur = getMax(node.left);
                // 需要将 node 左子树中的最大元素删除掉，然后赋值给successCur
                successCur.left = removeMax(node.left);
                successCur.right = node.right;
                //此时 node 节点已经没用
                node.left = node.right = null;
                return successCur;
            }
        }
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
