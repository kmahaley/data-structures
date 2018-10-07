package edu.basic.preparation.tree;

import java.util.ArrayList;
import java.util.List;

import edu.basic.preparation.data.TreeNode;

/**
 */
public class BinaryTree {

    public static List<Integer> inOrderList = new ArrayList<>();

    public static List<Integer> preOrderList = new ArrayList<>();

    public static List<Integer> postOrderList = new ArrayList<>();


    public static void inOrder(TreeNode start) {

        if (start != null) {
            inOrder(start.left);
            inOrderList.add(start.key);
            inOrder(start.right);
        }
    }

    public static void preOrder(TreeNode start) {

        if (start != null) {
            preOrderList.add(start.key);
            preOrder(start.left);
            preOrder(start.right);
        }
    }

    public static void postOrder(TreeNode start) {

        if (start != null) {
            postOrder(start.left);
            postOrder(start.right);
            postOrderList.add(start.key);
        }
    }

    public static boolean isBST(TreeNode current, int min, int max) {
        if (current == null) {
            return false;
        }

        if (current.key < min || current.key > max) {
            return false;
        }

        return isBST(current.left, min, current.key) && isBST(current.right, current.key, max);
    }

    public static int sizeOfTree(TreeNode start) {
        if (start == null) {
            return 0;
        }
        return sizeOfTree(start.left) + 1 + sizeOfTree(start.right);
    }
}
