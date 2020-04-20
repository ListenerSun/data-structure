package com.sqt.tree;

/**
 * @Description:
 * @author: ListenerSun(男, 未婚) 微信:810548252
 * @Date: Created in 2019-12-29 2:57
 */
public class BSTTest {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,2,6,9,1,3};
        for (int i : nums){
            bst.add(i);
        }
//        bst.preOrder();
//        System.out.println("/r/n");
////        bst.levelOrder();
//        System.out.println(bst.deleteMax());
//        System.out.println("/r/n");
        bst.deleteNode(6);
        bst.deleteNode(8);
        bst.preOrder();
        System.out.println(bst.size);
    }
}
