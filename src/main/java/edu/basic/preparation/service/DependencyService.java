package edu.basic.preparation.service;

import java.util.Arrays;
import java.util.List;

import static edu.basic.preparation.data.DataUtilities.nearestSmallerNumberOnLeftData;
import edu.basic.preparation.queue.MyQueue;
import static edu.basic.preparation.stack.MyStack.longestParenthesisString;
import edu.basic.preparation.string.StringUtilities;
import static edu.basic.preparation.string.StringUtilities.alternatingParityPermutations;
import static edu.basic.preparation.string.StringUtilities.closest;
import static edu.basic.preparation.string.StringUtilities.countMatches;
import static edu.basic.preparation.string.StringUtilities.fileReader;
import static edu.basic.preparation.string.StringUtilities.missingWords;
import static edu.basic.preparation.string.StringUtilities.missingWordsInInitialString;
import org.springframework.stereotype.Service;

/**
 * @author Kartik Mahaley
 */
@Service
public class DependencyService {

    public void listFunctionality() {
//        final MyList listForBasicOperation = getListForBasicOperation();
//        System.out.println("********* basic list operation ***********");
//        listForBasicOperation.print();

//        final Node middleElement = listForBasicOperation.middleElement();
//        System.out.println("Middle : " + middleElement.getKey());
//
//        System.out.println("********* delete list node operation ***********");
//        listForBasicOperation.delete(10);
//        listForBasicOperation.print();

//        System.out.println("********* reverseStack list operation ***********");
//        final Node reverseHead = listForBasicOperation.reverseStack();
//        printFromNode(reverseHead);
//
//        final Node recursiveReverseLinkedList = recursiveReverseLinkedList(reverseHead, null);
//        printFromNode(recursiveReverseLinkedList);

//        System.out.println("********* remove duplicate elements *******");
//        final MyList duplicatedElementList = getDuplicatedElementList();
//        System.out.print("original list : ");
//        printFromNode(duplicatedElementList.getHead());
//        removeDuplicates(duplicatedElementList.getHead());
//
//        System.out.println("********* find intersected node from list *******");
//        Node intersection = findIntersectedNode(getTwoIntersectedList());
//        if (intersection == null) {
//            System.out.println("No intersecting node");
//        } else {
//            printFromNode(intersection);
//        }
//
//        System.out.println("********* pairwise swap of node in list *******");
//        final Node listForPairwiseSwap = getListForPairwiseSwap();
//        printFromNode(listForPairwiseSwap);
//        final Node pairwiseSwapNode = reverseListInPairs(listForPairwiseSwap);
//        printFromNode(pairwiseSwapNode);
    }

    public void stringFunctionality() {

//        StringUtilities.getDuplicateInArrayWindow(DataUtilities.getIntegerArray(), 4);
//        StringUtilities.isStringUnique(DataUtilities.getString());
//        StringUtilities.stringURLify("Mr John Smith apple banana     ",26);
        StringUtilities.isPermutationPalindrome("apaa");

        final List<Integer> hackerrank = closest("abc", Arrays.asList(0, 2));
        System.out.println(hackerrank);

        System.out.println(" --------------------------- ");

        final List<String> missingWordList = missingWords("I like cheese", "I");
        missingWordList.forEach(str -> System.out.println(str));

        System.out.println(" --------------------------- ");
        List<String>  s1 = Arrays.asList("0100","1001","0011", "0011");
        List<String>  s2 = Arrays.asList("0101","1001","0011","0011");
        final int countMatches = countMatches(s1, s2);
        System.out.println(countMatches);


        System.out.println(" --------------------------- ");
        fileReader("fileName.txt");

        System.out.println(" --------------------------- ");
        final List<String> stringList =
                missingWordsInInitialString("i love mango and apple", "love and");
        System.out.println(stringList);

        System.out.println(" --------------------------- ");
        alternatingParityPermutations(4);
    }

    public void queueFunctionality() {

//        MyQueue.QueueUsingTwoStacks queueUsingTwoStacks = new MyQueue.QueueUsingTwoStacks();
//        queueUsingTwoStacks.enQueue(10);
//        queueUsingTwoStacks.enQueue(20);
//        queueUsingTwoStacks.enQueue(30);
//        queueUsingTwoStacks.enQueue(40);
//
//        System.out.println(queueUsingTwoStacks.toString());
//
//        final int first = queueUsingTwoStacks.deQueue();
//        final int second = queueUsingTwoStacks.deQueue();
//        final int third = queueUsingTwoStacks.deQueue();
//        final int four = queueUsingTwoStacks.deQueue();

        MyQueue.QueueUsingOneStacks queueUsingOneStacks = new MyQueue.QueueUsingOneStacks();
        queueUsingOneStacks.enQueue(10);
        queueUsingOneStacks.enQueue(20);
        queueUsingOneStacks.enQueue(30);
        queueUsingOneStacks.enQueue(40);
        queueUsingOneStacks.enQueue(50);

        System.out.println(queueUsingOneStacks);
        queueUsingOneStacks.deQueue();
        System.out.println(queueUsingOneStacks);
//
//        System.out.println(Arrays.asList(first, second, third, four));
//
//        priorityQueue();
//
//        setImplementation();
//
//        priorityQueueImplementation();
//
//        mapImplementation();

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

//        System.out.println("Input array : " + Arrays.toString(input));
//        System.out.println("********* nearest smaller number on left *******");
//        nearestSmallerNumberOnLeft(input);
//        System.out.println("********* next nearest smaller number *******");
//        nextSmallestElement(input);
//        System.out.println("********* next nearest greater number *******");
//        nextGreatestElement(input);

//        System.out.println("********* sort a stack using recursion stack *******");
//        final Stack<Integer> stack = basicStack();
//        System.out.println(stack);
//        sortStack(stack);
//        System.out.println(stack);
//
//        System.out.println("********* Reverse stack using recursion *******");
//        final Stack<Integer> stackOriginal = basicStack();
//        System.out.println(stackOriginal);
//        reverseStack(stackOriginal);
//        System.out.println(stackOriginal);

        System.out.println("********* Longest parenthesis sequence *******");
        int size = longestParenthesisString(")()())");
        System.out.println(size);
    }


    public void binaryTreeFunctionality() {
//        System.out.println("********* inorder tree traversal *******");
//        inOrder(constructTree());
//        System.out.println(inOrderList);
//
//        System.out.println("********* is tree BST *******");
//        System.out.println(isBST(constructTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println("********* Size of the tree *******");
//        System.out.println(sizeOfTree(constructTree()));
//        System.out.println("********* find maximum of the tree *******");
//        System.out.println(findMax(constructTree()));
//
//        System.out.println("********* Horizontal distance *******");
//        final Map<Integer, LinkedList<Integer>> integerListMap = horizontalDistance(constructDiagonalTraversal());
//        integerListMap.forEach((k, v) -> System.out.println("H distance from root: " + k + " nodes: " + v));
//
//        System.out.println("********* Diagonal Traversal of Binary Tree *********");
//        diagonalPrint(constructDiagonalTraversal());
//        System.out.println("********* Sum of longest path to leaf *******");
//        System.out.println(longRootToLeafPath(constructTree()));

//        System.out.println("********* is path from root to leaf exists with sum *******");
//        System.out.println(isPathExistsWithSum(constructTree(), 86));
//        System.out.println("********* All paths from root to leaf *******");
//        allPathsFromRootToLeaf(constructTree(), new ArrayList<Integer>(), 0);

//        System.out.println("********* All paths from root with given sum *******");
//        allPathsFromRootWithGivenSum(constructTreeWithSumPath(), 0, 38, new ArrayList<Integer>(), 0);
    }


}
