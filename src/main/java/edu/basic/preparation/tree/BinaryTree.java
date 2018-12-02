package edu.basic.preparation.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
    public static int sizeOfTreeRecursive(TreeNode start) {
        if (start == null) {
            return 0;
        }
        return sizeOfTreeRecursive(start.left) + 1 + sizeOfTreeRecursive(start.right);
    }

    //Size of tree iterative
    public static int sizeOfTreeIterative(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0;
        while (!queue.isEmpty()){
            final TreeNode current = queue.remove();
            count++;
            if(current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return count;
    }

    //Height of the tree recursive
    public static int heightOfTreeRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = heightOfTreeRecursive(root.left);
        int rh = heightOfTreeRecursive(root.right);

        return lh > rh ? lh + 1 : rh + 1;
    }

    // height of the tree iterative
    public static int heightOfTreeIterative(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count =0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                final TreeNode current = queue.remove();
                if(current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }

        }
        return count;
    }


    //count number of leaf nodes iterative
    public static int countNumberOfLeafNodesIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            final TreeNode current = queue.remove();

            if (current.left == null && current.right == null) {
                count++;
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return count;
    }

    //count number of leaf nodes recursive
    public static int countNumberOfLeafNodesRecursive(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNumberOfLeafNodesRecursive(root.left) + countNumberOfLeafNodesRecursive(root.right);
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


    /**
     * check if binary tree is full binary tree, each node with 0 or 2 children
     *
     * @param root node
     *
     * @return true if node has 0 or 2 children
     */
    public static boolean isFullBinaryTreeRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullBinaryTreeRecursive(root.left) && isFullBinaryTreeRecursive(root.right);
        }
        return false;
    }

    /**
     * check if node has just left or right node then return false
     *
     * @param root node
     * @return true or false
     */
    public static boolean isFullBinaryTreeIterative(TreeNode root) {

        if(root == null)
            return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final TreeNode polled = queue.poll();

            if(polled.left != null && polled.right != null){
                queue.add(polled.left);
                queue.add(polled.right);
            } else if (polled.left != null || polled.right != null){
                return false;
            }
        }
        return true;
    }

    /**
     * 1. left == null && right != null  --> false
     * 2. all nodes first after half filled or leaf node should be leaf node
     * 3. else all true
     *
     * @param root node
     * @return true or false
     */
    public static boolean isCompleteBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isNonCompleteNode = false;
        while (!queue.isEmpty()) {

            final TreeNode poll = queue.poll();

            if (isNonCompleteNode && (poll.left != null || poll.right != null)) {
                return false;
            }

            if (poll.left == null && poll.right != null) {
                return false;
            }

            //Left not null
            if (poll.left != null) {
                queue.add(poll.left);
            } else {
                isNonCompleteNode = true;
            }
            // right not null
            if (poll.right != null) {
                queue.add(poll.right);
            } else {
                isNonCompleteNode = true;
            }
        }
        return true;
    }

    /**
     * Get number of nodes in a binary tree.
     * every leftNodeIndex = 2*index+1 and rightNodeIndex = 2*index+2
     * index of node should always be less than number of nodes in binary tree
     *
     * @param root node
     */
    public static void isCompleteBinaryTreeRecursive(TreeNode root) {

        final int sizeOfTree = sizeOfTreeRecursive(root);
        if (isCompleteBinaryTreeRecursiveHelper(root, 0, sizeOfTree)) {
            System.out.println("Tree is complete");
        } else {
            System.out.println("Tree is not complete");
        }
    }

    /* This function checks if the binary tree is complete or not */
    public static boolean isCompleteBinaryTreeRecursiveHelper(TreeNode root, int index, int numberOfNodes) {
        // An empty tree is complete
        if (root == null) {
            return true;
        }

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index >= numberOfNodes) {
            return false;
        }

        // Recursive call for left and right subtrees
        return (isCompleteBinaryTreeRecursiveHelper(root.left, 2 * index + 1, numberOfNodes)
                && isCompleteBinaryTreeRecursiveHelper(root.right, 2 * index + 2, numberOfNodes));

    }

    /**
     * Get lowest key in binary search tree
     *
     * @param node node
     */
    public static void getLowestNodeInBST(TreeNode node){
        System.out.println("Iterative : "+findLowestInBinarySearchTreeIterative(node));
        System.out.println("Recursive : "+findLowestInBinarySearchTreeRecursive(node));
    }

    public static int findLowestInBinarySearchTreeIterative(TreeNode root){
        if(root == null){
            return -1;
        } else {
            TreeNode curr = root;
            while (curr.left != null){
                curr = curr.left;
            }
            return curr.key;
        }

    }
    public static int findLowestInBinarySearchTreeRecursive(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.key;
        }
        return findLowestInBinarySearchTreeRecursive(root.left);
    }

    /**
     * Is tree prefect binary tree or not
     *
     * @param root node
     * @return boolean
     */
    public static boolean isPerfectBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isPerfect = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            //children on diff level
            if (isPerfect && size > 0) {
                return false;
            }
            //iterate for same level
            for (int i = 0; i < size; i++) {
                final TreeNode curr = queue.poll();

                if (curr.left != null && curr.right != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                } else if (curr.left != null || curr.right != null) {
                    return false;
                }

                // found leaf
                if (curr.left == null && curr.right == null) {
                    isPerfect = true;
                }
            }
        }
        return isPerfect;
    }

    public static boolean isPerfectBinaryTreeRecursive(TreeNode root){
        final int height = heightOfTreeRecursive(root);
        return isPerfectBinaryTreeRecursiveHelper(root, height, 1);
    }
    /**
     * All leaf node should be at same level and other nodes should be filled(2 nodes)
     * @param root node
     * @param depth depth of the tree
     * @param level current level
     * @return boolean
     */
    public static boolean isPerfectBinaryTreeRecursiveHelper(TreeNode root, int depth, int level) {

        if (root == null) {
            return true;
        }

        //leaf found and if depth is equal to level
        if (root.left == null && root.right == null) {
            return depth == level;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfectBinaryTreeRecursiveHelper(root.left, depth, level + 1) &&
                isPerfectBinaryTreeRecursiveHelper(root.right, depth, level + 1);
    }
}
