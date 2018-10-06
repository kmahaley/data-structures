package edu.basic.preparation.data;

import java.util.Arrays;
import java.util.List;
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

    private DataUtilities() {
    }
}
