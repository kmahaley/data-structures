package edu.basic.preparation.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.basic.preparation.data.TreeNode;
import org.apache.commons.collections4.CollectionUtils;

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

    //horizontal distance of nodes from root
    public static Map<Integer, LinkedList<Integer>> horizontalDistance(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<DistanceTreeNode> nodes = new LinkedList<>();
        nodes.add(new DistanceTreeNode(root, 0));
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        while (!nodes.isEmpty()) {
            final DistanceTreeNode polled = nodes.poll();
            final TreeNode current = polled.node;
            final int dis = polled.dis;
            if (map.containsKey(dis)) {
                final LinkedList<Integer> nodeList = map.get(dis);
                nodeList.add(current.key);
                map.put(dis, nodeList);
            } else {
                final LinkedList<Integer> list = new LinkedList<>();
                list.add(current.key);
                map.put(dis, list);
            }
            if (current.left != null) {
                nodes.add(new DistanceTreeNode(current.left, dis - 1));
            }
            if (current.right != null) {
                nodes.add(new DistanceTreeNode(current.right, dis + 1));
            }
        }
        return map;

    }


    //Diagonal traversal needs horizontal distance
    public static void diagonalTraversal(Map<Integer, LinkedList<Integer>> map) {

        final Iterator<Integer> iterator = map
                .keySet()
                .iterator();
        while (iterator.hasNext()){
            int tempDistance = iterator.next();
            while (map.containsKey(tempDistance)) {

                final LinkedList<Integer> integerLinkedList = map.get(tempDistance);

                if (CollectionUtils.isNotEmpty(integerLinkedList)) {
                    System.out.print(integerLinkedList.poll() + " - ");
                    map.put(tempDistance, integerLinkedList);
                } else {
                    iterator.remove();
                }
                tempDistance++;
            }
            System.out.println();
        }

    }

    //is tree BST left < root < right
    public static boolean isBST(TreeNode current, int min, int max) {
        if (current == null) {
            return true;
        }

        if (current.key < min || current.key > max) {
            return false;
        }

        return isBST(current.left, min, current.key) && isBST(current.right, current.key, max);
    }

    // add nodes to determine size of the tree
    public static int sizeOfTree(TreeNode start) {
        if (start == null) {
            return 0;
        }
        return sizeOfTree(start.left) + 1 + sizeOfTree(start.right);
    }

    //Maximum in the tree
    public static int findMax(TreeNode current) {
        if (current == null) {
            return -1;
        }
        int maxLeft = findMax(current.left);
        int maxRight = findMax(current.right);

        if (current.key > maxLeft && current.key > maxRight) {
            return current.key;
        } else if (maxLeft > current.key && maxLeft > maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    //to keep track of horizontal distance of the node
    public static class DistanceTreeNode {
        TreeNode node;
        int dis;

        public DistanceTreeNode(TreeNode node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
}
