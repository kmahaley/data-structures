package edu.basic.preparation.service;

import java.util.Arrays;
import java.util.Stack;

import static edu.basic.preparation.data.DataUtilities.basicStack;
import static edu.basic.preparation.data.DataUtilities.constructTree;
import static edu.basic.preparation.data.DataUtilities.getDuplicatedElementList;
import static edu.basic.preparation.data.DataUtilities.getListForBasicOperation;
import static edu.basic.preparation.data.DataUtilities.getListForPairwiseSwap;
import static edu.basic.preparation.data.DataUtilities.getTwoIntersectedList;
import static edu.basic.preparation.data.DataUtilities.nearestSmallerNumberOnLeftData;
import edu.basic.preparation.data.Node;
import edu.basic.preparation.list.MyList;
import static edu.basic.preparation.list.MyList.findIntersectedNode;
import static edu.basic.preparation.list.MyList.printFromNode;
import static edu.basic.preparation.list.MyList.removeDuplicates;
import static edu.basic.preparation.list.MyList.reverseListInPairs;
import edu.basic.preparation.queue.MyQueue;
import static edu.basic.preparation.queue.MyQueue.priorityQueue;
import static edu.basic.preparation.stack.MyStack.nearestSmallerNumberOnLeft;
import static edu.basic.preparation.stack.MyStack.nextGreatestElement;
import static edu.basic.preparation.stack.MyStack.nextSmallestElement;
import static edu.basic.preparation.stack.MyStack.reverseStack;
import edu.basic.preparation.string.StringUtilities;
import static edu.basic.preparation.tree.BinaryTree.inOrder;
import static edu.basic.preparation.tree.BinaryTree.inOrderList;
import org.springframework.stereotype.Service;

/**
 * @author Kartik Mahaley
 */
@Service
public class DependencyService {

    public void listFunctionality() {
        final MyList listForBasicOperation = getListForBasicOperation();
        System.out.println("********* basic list operation ***********");
        listForBasicOperation.print();

        final Node middleElement = listForBasicOperation.middleElement();
        System.out.println("Middle : " + middleElement.getKey());

        System.out.println("********* delete list node operation ***********");
        listForBasicOperation.delete(10);
        listForBasicOperation.print();

        System.out.println("********* reverse list operation ***********");
        final Node reverseHead = listForBasicOperation.reverse();
        printFromNode(reverseHead);

        System.out.println("********* remove duplicate elements *******");
        final MyList duplicatedElementList = getDuplicatedElementList();
        System.out.print("original list : ");
        printFromNode(duplicatedElementList.getHead());
        removeDuplicates(duplicatedElementList.getHead());

        System.out.println("********* find intersected node from list *******");
        Node intersection = findIntersectedNode(getTwoIntersectedList());
        if (intersection == null) {
            System.out.println("No intersecting node");
        } else {
            printFromNode(intersection);
        }

        System.out.println("********* pairwise swap of node in list *******");
        final Node listForPairwiseSwap = getListForPairwiseSwap();
        printFromNode(listForPairwiseSwap);
        final Node pairwiseSwapNode = reverseListInPairs(listForPairwiseSwap);
        printFromNode(pairwiseSwapNode);
    }

    public void stringFunctionality() {

//        StringUtilities.getDuplicateInArrayWindow(DataUtilities.getIntegerArray(), 4);
//        StringUtilities.isStringUnique(DataUtilities.getString());
//        StringUtilities.stringURLify("Mr John Smith apple banana     ",26);
        StringUtilities.isPermutationPalindrome("apaa");
    }

    public void queueFunctionality() {

        MyQueue.QueueUsingTwoStacks queueUsingTwoStacks = new MyQueue.QueueUsingTwoStacks();
        queueUsingTwoStacks.enQueue(10);
        queueUsingTwoStacks.enQueue(20);
        queueUsingTwoStacks.enQueue(30);
        queueUsingTwoStacks.enQueue(40);

        System.out.println(queueUsingTwoStacks.toString());

        final int first = queueUsingTwoStacks.deQueue();
        final int second = queueUsingTwoStacks.deQueue();
        final int third = queueUsingTwoStacks.deQueue();
        final int four = queueUsingTwoStacks.deQueue();

        System.out.println(Arrays.asList(first, second, third, four));

        priorityQueue();
    }

    public void stackFunctionality() {
//        MyStack.StackUsingTwoQueue stackUsingTwoQueue = new MyStack.StackUsingTwoQueue();
//        stackUsingTwoQueue.push(10);
//        stackUsingTwoQueue.push(20);
//        stackUsingTwoQueue.push(30);
//        stackUsingTwoQueue.push(40);
//        stackUsingTwoQueue.push(50);
//        System.out.println(stackUsingTwoQueue.toString());
//        System.out.println(stackUsingTwoQueue.pop() +" - "+stackUsingTwoQueue.pop());

        final int[] input = nearestSmallerNumberOnLeftData();

        System.out.println("Input array : " + Arrays.toString(input));
        System.out.println("********* nearest smaller number on left *******");
        nearestSmallerNumberOnLeft(input);
        System.out.println("********* next nearest smaller number *******");
        nextSmallestElement(input);
        System.out.println("********* next nearest greater number *******");
        nextGreatestElement(input);
        System.out.println("********* reverse a stack using auxiliary stack *******");
        final Stack<Integer> stack = basicStack();
        reverseStack(stack);
    }


    public void binaryTreeFunctionality() {
        System.out.println("********* inorder tree traversal *******");
        inOrder(constructTree());
        System.out.println(inOrderList);
        System.out.println("********* preorder tree traversal *******");
    }
}
