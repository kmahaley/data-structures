package edu.basic.preparation.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import edu.basic.preparation.list.MyList;

/**
 *
 * @author Kartik Mahaley
 */
public final class DataUtilities {

    public static int[] getIntegerArray() {
        return new int[]{1, 2, 1, 3, 4, 2, 3};
    }

    public static String getString() {
        return "tactomac";
    }

    public static MyList getDuplicatedElementList(){
        MyList myList = new MyList();
        myList.add(11);
        myList.add(11);
        myList.add(11);
        myList.add(21);
        myList.add(43);
        myList.add(43);
        myList.add(60);
        return myList;
    }

    public static Node getDuplicatedNodesList(){
        Node head = new Node(10);
        head.setNext(new Node(10));
        head.getNext().setNext(new Node(10));
        head.getNext().getNext().setNext(new Node(40));
        head.getNext().getNext().getNext().setNext(new Node(80));
        head.getNext().getNext().getNext().getNext().setNext(new Node(60));
        head.getNext().getNext().getNext().getNext().getNext().setNext(new Node(20));
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(10));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(90));
        head.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().setNext(new Node(10));

        return head;
    }

    public static Node getDuplicatedNodesList_ToKeepUniqueNodes(){
        Node head = new Node(1);
        head.setNext(new Node(1));
        head.getNext().setNext(new Node(2));
        head.getNext().getNext().setNext(new Node(3));
        head.getNext().getNext().getNext().setNext(new Node(3));
        head.getNext().getNext().getNext().getNext().setNext(new Node(4));

        return head;
    }

    public static List<Node> getTwoSortedList(){


        Node head1 = new Node(1);
        head1.setNext(new Node(2));
        head1.getNext().setNext(new Node(4));

        Node head2 = new Node(1);
        head2.setNext(new Node(3));
        head2.getNext().setNext(new Node(4));

        return Arrays.asList(head1, head2);
    }

    public static  MyList getListForBasicOperation(){
        MyList myList = new MyList();
        myList.add(10);
        myList.add(40);
        myList.add(70);
        myList.add(90);
        myList.addAtFront(5);
        myList.addInMiddle(75,4);
        myList.add(10);
        myList.add(10);
        return myList;
    }

    public static List<Node> getTwoIntersectedList(){
        Node intersected = new Node(50);
        intersected.setNext(new Node(60));
        intersected.getNext().setNext(new Node(70));
        intersected.getNext().getNext().setNext(new Node(80));

        MyList myList1 = new MyList();
        myList1.setHead(new Node(1));
        myList1.getHead().setNext(new Node(4));
        myList1.getHead().getNext().setNext(new Node(12));
        myList1.getHead().getNext().getNext().setNext(new Node(7));
        myList1.getHead().getNext().getNext().getNext().setNext(intersected);

        MyList myList2 = new MyList();
        myList2.setHead(new Node(41));
        myList2.getHead().setNext(new Node(100));

        return Arrays.asList(myList1.getHead(), myList2.getHead());
    }

    public static  Node getListForPairwiseSwap(){
        MyList myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        return myList.getHead();
    }

    public static int[] nearestSmallerNumberOnLeftData(){
        return new int[] {1,3,0,2,5};
    }

    public static Stack<Integer> basicStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(92);
        stack.push(98);
        stack.push(23);

        return stack;
    }

    public static TreeNode constructTree() {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(18);
        root.left.right.left = new TreeNode(16);
        root.left.right.right = new TreeNode(19);
        root.left.right.left.right = new TreeNode(17);

        return root;
    }

    public static TreeNode constructDiameterTree() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(8);

        return root;
    }

    public static TreeNode longestPathTree() {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(10);
        root.left.left.left = new TreeNode(2);

        return root;
    }


    public static TreeNode isTreePerfectBinaryTree() {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(18);
//        root.right.left = new TreeNode(16);
//        root.right.right = new TreeNode(19);
//        root.left.right.left.right = new TreeNode(17);

        return root;
    }

    public static TreeNode constructDiagonalTraversal() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        return root;
    }

    public static TreeNode constructTreeWithSumPath() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(28);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);
        return root;
    }

    public static TreeNode node1() {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(28);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        return root;
    }

    public static TreeNode node2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(13);
        root.right = new TreeNode(28);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(14);

        return root;
    }

    public static Map<Integer, List<Integer>> constructGraph(){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2, 3));
        graph.put(1, Arrays.asList(4, 5));
        graph.put(2, Arrays.asList(6));
        graph.put(3, Arrays.asList(7, 8));
        graph.put(4, new LinkedList<>());
        graph.put(5, new LinkedList<>());
        graph.put(6, Arrays.asList(12));
        graph.put(7, new LinkedList<>());
        graph.put(8, Arrays.asList(9));
        graph.put(9, new LinkedList<>());
        graph.put(12, new LinkedList<>());

        return graph;
    }


    public static Map<Integer, List<Integer>> constructDirectedCyclicGraph(){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, new LinkedList<>());

        return graph;
    }

    public static Map<Integer, List<Integer>> constructDirectedCyclicGraph2(){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6));
        graph.put(6, Arrays.asList(1));

        return graph;
    }

    private DataUtilities() {
    }
}
