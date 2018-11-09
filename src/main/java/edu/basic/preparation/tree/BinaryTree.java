package edu.basic.preparation.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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

    /**
     * horizontal distance of nodes from root
     *
     * bottom view is last node from listOfNodes
     * top view is first node from listOfNodes
     *
     * @param root node
     * @return Map of distance and nodes <key listOfNodes> ie. < 0, <1,2,3> > etc
     */
    public static Map<Integer, LinkedList<Integer>> horizontalDistance(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<DistanceTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(new DistanceTreeNode(root, 0));
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        while (!nodeQueue.isEmpty()) {
            final DistanceTreeNode polled = nodeQueue.poll();
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
                nodeQueue.add(new DistanceTreeNode(current.left, dis - 1));
            }
            if (current.right != null) {
                nodeQueue.add(new DistanceTreeNode(current.right, dis + 1));
            }
        }
        return map;

    }


    //Geek for geeks solution
    /**
     * all right child will have same slope which is denoted by slope
     * @param root node
     * @param slope slope
     * @param diagonalPrint diagonal nodes map
     */
    public static void diagonalPrintUtil(TreeNode root, int slope, HashMap<Integer, Vector<Integer>> diagonalPrint) {
        // Base case
        if (root == null) {
            return;
        }
        // get the list at the particular slope value
        Vector<Integer> list = diagonalPrint.get(slope);

        // list is null then create a vector and store the data
        if (list == null) {
            list = new Vector<>();
            list.add(root.key);
        } else {
            list.add(root.key);
        }

        // Store all nodes of same line together as a vector
        diagonalPrint.put(slope, list);

        // Increase the vertical slope if left child
        diagonalPrintUtil(root.left, slope + 1, diagonalPrint);

        // Vertical slope remains same for right child
        diagonalPrintUtil(root.right, slope, diagonalPrint);
    }

    // Print diagonal traversal of given binary tree
    public static void diagonalPrint(TreeNode root) {
        // create a map of vectors to store Diagonal elements
        HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();
        diagonalPrintUtil(root, 0, diagonalPrint);

        diagonalPrint.forEach((k, v) -> System.out.println(v));
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

    /**
     * Maximum sum to longest path to leaf
     *
     * @param root tree node
     * @return max sum
     */
    public static int longRootToLeafPath(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLength = 0;

        return longRootToLeafPathUtil(root, maxLength, maxSum, 0, 0);

    }

    /**
     * evaluate maximum sum
     *
     * @param root node
     * @param maxLength max length
     * @param maxSum max sum
     * @param len current length
     * @param sum current sum
     *
     * @return max sum
     */
    public static int longRootToLeafPathUtil(
            TreeNode root,
            int maxLength,
            int maxSum,
            int len,
            int sum) {

        if (root == null) {
            if (len > maxLength) {
                maxSum = sum;
                maxLength = len;

            } else if (maxLength == len && sum > maxSum) {
                maxSum = sum;
            }
            return maxSum;
        }
        int left = longRootToLeafPathUtil(root.left, maxLength, maxSum, len + 1, sum + root.key);
        int right = longRootToLeafPathUtil(root.right, maxLength, maxSum, len + 1, sum + root.key);

        return left > right ? left : right;
    }

    /**
     * Path from root to leaf exists with given sum or not
     *
     * @param root node
     * @param sum sum
     * @return true is path exists equals to sum
     */
    public static boolean isPathExistsWithSum(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        sum = sum - root.key;
        boolean isExists = false;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        //as soon as you get true, compare with other part of the tree and return
        if (root.left != null) {
            isExists = isExists || isPathExistsWithSum(root.left, sum);
        }
        if (root.right != null) {
            isExists = isExists || isPathExistsWithSum(root.right, sum);
        }

        return isExists;
    }


    /**
     * Print all paths from root to leaf
     *
     * @param root node
     * @param list list to keep path
     * @param index index at which element will be added
     */
    public static void allPathsFromRootToLeaf(TreeNode root, List<Integer> list, int index) {
        if (root == null) {
            return;
        }

        list.add(index, root.key);
        index++;
        //condition for leaf node
        if (root.left == null && root.right == null) {
            printList(list, index);
        }

        allPathsFromRootToLeaf(root.left, list, index);
        allPathsFromRootToLeaf(root.right, list, index);
    }

    /**
     * find all paths from root to nodes with maximum given sum
     *
     * @param root node
     * @param sum current sum
     * @param maxSum expected max sum
     * @param list list to keep track of node till now
     * @param index index of current node
     */
    public static void allPathsFromRootWithGivenSum(TreeNode root, int sum, int maxSum,List<Integer> list, int index) {
        if (root == null) {
            return;
        }

        sum = sum + root.key;
        list.add(index, root.key);
        index++;

        //condition for maxSum
        if (sum == maxSum) {
            printList(list, index);
        }

        allPathsFromRootWithGivenSum(root.left, sum, maxSum,list, index);
        allPathsFromRootWithGivenSum(root.right, sum, maxSum,list, index);
    }

    private static void printList(List<Integer> list, int index) {
        for (int i = 0; i < index ; i++) {
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }
}
