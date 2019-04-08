package edu.basic.preparation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import edu.basic.preparation.stack.MyStack;
import org.springframework.stereotype.Service;

import static edu.basic.preparation.array.Array.getAllCombinations;
import static edu.basic.preparation.data.DataUtilities.listOfList;
import static edu.basic.preparation.string.StringUtilities.findMissingElementInDuplicate;

/**
 * @author Kartik Mahaley
 */
@Service
public class DependencyService {

    public void listFunctionality() {
//        final MyList listForBasicOperation = getListForBasicOperation();
//        System.out.println("********* basic list operation ***********");
//        listForBasicOperation.print();

//        System.out.println("********* basic list operation and get length iterative and recursive ***********");
//        printFromNode(getListForPairwiseSwap());
//        final int lengthRecursive = getLengthRecursive(getListForPairwiseSwap(), 0);
//        final int length = length(getListForPairwiseSwap());
//        final int lengthRecursive2 = getLengthRecursive2(getListForPairwiseSwap());
//        System.out.println(length +" - "+ lengthRecursive +" - "+lengthRecursive2);

//        System.out.println("********* get nth node from last ***********");
//        System.out.println(getNthNodeFromLinkedList(getListForPairwiseSwap(), 5));

//        System.out.println("********* delete all occurences from list ***********");
//        final Node duplicatedNodesList = getDuplicatedNodesList();
//        printFromNode(duplicatedNodesList);
//        final Node newHead = deleteAllOccurencesOfNode(duplicatedNodesList, 10);
//        printFromNode(newHead);

//        System.out.println("********* search in list ***********");
//        System.out.println(getElementIndexPosition(getListForPairwiseSwap(), 12, 1));
//        System.out.println(searchRecursive(getListForPairwiseSwap(), 1));

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
//        final Node pairwiseSwapNode = swapPairsUsingPointers(listForPairwiseSwap);
//        printFromNode(pairwiseSwapNode);

//        Node head = new Node(4);
//        head.setNext(new Node(5));
//        head.getNext().setNext(new Node(1));
//        head.getNext().getNext().setNext(new Node(8));
//        head.getNext().getNext().getNext().setNext(new Node(8));
//        head.getNext().getNext().getNext().getNext().setNext(new Node(9));
//        printFromNode(head);
//        deleteNode(head.next);
//        deleteNode(head, 8);
//        printFromNode(head);

//        final List<Node> twoSortedList = getTwoSortedList();
//        final Node mergeTwoLists = mergeTwoLists(twoSortedList.get(0), twoSortedList.get(1));
//        printFromNode(mergeTwoLists);

//        final Node node1 = getDuplicatedNodesList_ToKeepUniqueNodes();
//        printFromNode(node1);
//        Node start = keepUniqueNodes(node1);
//        printFromNode(start);

//        final Node node = getListForPairwiseSwap();
//        printFromNode(node);
//        final Node reverseBetween1 = reverseBetweenOptimized(node, 2, 4);
//        printFromNode(reverseBetween1);

//        Node l1 = new Node(5);
//        Node l2 = new Node(5);
//        final Node head = addTwoNumbers(l1, l2);
//        printFromNode(head);

//        final Node initialState = getListForPairwiseSwap();
//        printFromNode(initialState);
//        final Node rotatedNode = rotateRight(initialState, 2);
//        printFromNode(rotatedNode);

//        final Node partitionFromListNode = partitionList();
//        printFromNode(partitionFromListNode);
//        final Node partitionedList = partition(partitionFromListNode, 3);
//        printFromNode(partitionedList);

//        final Node initialState = getListForPairwiseSwap();
//        printFromNode(initialState);
//        reorderList(initialState);
//        printFromNode(initialState);
    }

    public void stringFunctionality() {

//        StringUtilities.getDuplicateInArrayWindow(DataUtilities.getIntegerArray(), 4);
//        StringUtilities.isStringUnique(DataUtilities.getString());
//        StringUtilities.stringURLify("Mr John Smith apple banana     ",26);
//        StringUtilities.isPermutationPalindrome("apaa");
//
//        final List<Integer> hackerrank = closest("abc", Arrays.asList(0, 2));
//        System.out.println(hackerrank);
//
//        System.out.println(" --------------------------- ");
//
//        final List<String> missingWordList = missingWords("I like cheese", "I");
//        missingWordList.forEach(str -> System.out.println(str));
//
//        System.out.println(" -------------Island problem-------------- ");
//        List<String>  s1 = Arrays.asList("0100","1001","0011", "0011");
//        List<String>  s2 = Arrays.asList("0101","1001","0011","0011");
//        final int countMatches = countMatches(s1, s2);
//        System.out.println(countMatches);
//
//
//        System.out.println(" -------------File reader-------------- ");
//        fileReader("fileName.txt");
//
//        System.out.println(" ------------Missing words--------------- ");
//        final List<String> stringList =
//                missingWordsInInitialString("i love mango and apple", "love and");
//        System.out.println(stringList);
//
//        System.out.println(" --------------------------- ");
//        alternatingParityPermutations(4);

//        System.out.println(" -------------Permutation of string-------------- ");
//        permutationOfString("","123");

//        System.out.println(" -------------Recursively reverse string-------------- ");
//        reverseString("","apple");
//
//        System.out.println(" -------------Substrings of the string-------------- ");
//        subStringsOfString("abcd");

//        System.out.println(" -------------Permutations of the array-------------- ");
//        permutationOfArray(Arrays.asList(1,2,3,4), 0);

//        System.out.println(" -------------Permutations of the string-------------- ");
//        final List<String> strings = transformString("a1b2");
//        System.out.println(strings);

//        final List<List<Integer>> lists = optimalUtilization(23, foregrd(), backgrd());
//        System.out.println(lists);

//        System.out.println(" -------------Find 1 missing element in 1 to n-------------- ");
//        int[] arr = new int[] {1,2,4,5,6};
//        System.out.println(findMissingElement(arr, 5));

        System.out.println(" -------------Find 1 missing element in duplicate element array in 1 to n-------------- ");
        int[] oneDuplicate = new int[] {1,2,4,5,2};
        System.out.println(findMissingElementInDuplicate(oneDuplicate));

    }

    private List<List<Integer>> foregrd() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1, 13)));
        result.add(new ArrayList<>(Arrays.asList(2, 8)));
        result.add(new ArrayList<>(Arrays.asList(3, 2)));
        result.add(new ArrayList<>(Arrays.asList(4, 9)));
        result.add(new ArrayList<>(Arrays.asList(4, 19)));
        return result;
    }

    private List<List<Integer>> backgrd() {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1, 1)));
        result.add(new ArrayList<>(Arrays.asList(2, 2)));
        result.add(new ArrayList<>(Arrays.asList(3, 15)));
        result.add(new ArrayList<>(Arrays.asList(4, 10)));
        result.add(new ArrayList<>(Arrays.asList(4, 20)));
        return result;
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

//        MyQueue.QueueUsingOneStacks queueUsingOneStacks = new MyQueue.QueueUsingOneStacks();
//        queueUsingOneStacks.enQueue(10);
//        queueUsingOneStacks.enQueue(20);
//        queueUsingOneStacks.enQueue(30);
//        queueUsingOneStacks.enQueue(40);
//        queueUsingOneStacks.enQueue(50);
//
//        System.out.println(queueUsingOneStacks);
//        queueUsingOneStacks.deQueue();
//        System.out.println(queueUsingOneStacks);
//
//        System.out.println(Arrays.asList(first, second, third, four));
//
//        priorityQueue();
//
//        treeSet();
//
//        priorityQueueImplementation();
//
//        mapImplementation();

//        MyStack.StackUsingPriorityQueue stackUsingPriorityQueue = new MyStack.StackUsingPriorityQueue();
//        stackUsingPriorityQueue.push(6,10);
//        stackUsingPriorityQueue.push(3,7);
//        stackUsingPriorityQueue.push(4,8);
//        stackUsingPriorityQueue.push(2,5);
//        stackUsingPriorityQueue.push(1,2);
//        stackUsingPriorityQueue.push(5,9);
//
//        stackUsingPriorityQueue.pop();
//        stackUsingPriorityQueue.pop();
//        stackUsingPriorityQueue.pop();

//        final List<Integer> splitQueue = splitQueue(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        System.out.println(splitQueue);

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

        MyStack.StackUsingSingleQueue stackUsingSingleQueue = new MyStack.StackUsingSingleQueue();
        stackUsingSingleQueue.push(1);
        stackUsingSingleQueue.push(2);
        stackUsingSingleQueue.push(3);
        stackUsingSingleQueue.push(4);
        System.out.println(stackUsingSingleQueue);
        System.out.println(stackUsingSingleQueue.pop());
        System.out.println(stackUsingSingleQueue.pop());
        System.out.println(stackUsingSingleQueue);

//        final int[] input = nearestSmallerNumberOnLeftData();

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
//        System.out.println(sortStackIteratively(stack));
//
//        System.out.println("********* Reverse stack using recursion *******");
//        final Stack<Integer> stackOriginal = basicStack();
//        System.out.println(stackOriginal);
//        reverseStack(stackOriginal);
//        System.out.println(stackOriginal);

//        System.out.println("********* Longest parenthesis sequence *******");
//        int size = longestParenthesisString(")()())");
//        System.out.println(size);

//        System.out.println("********* Longest parenthesis sequence *******");
//        final Stack<Integer> integerStack = basicStack();
//        System.out.println(integerStack);
//        deleteMiddleElement(integerStack, integerStack.size(), integerStack.size()-1);
//        System.out.println(integerStack);

//        MyStack.MaxStackClass maxStackClass = new MyStack.MaxStackClass();
//        maxStackClass.push(8);
//        maxStackClass.push(7);
//        maxStackClass.push(4);
//        maxStackClass.push(3);
//        maxStackClass.push(9);
//        System.out.println(maxStackClass);
//        System.out.println(maxStackClass.getMax().data);
//        final MyStack.MaxClassNode pop1 = maxStackClass.pop();
//        System.out.println(pop1.data);
//        System.out.println(maxStackClass.getMax().data);
//        final MyStack.MaxClassNode pop2 = maxStackClass.pop();
//        System.out.println(pop2.data);
    }


    public void binaryTreeFunctionality() {
//        System.out.println("********* inorder tree traversal *******");
//        inOrder(constructTree());
//        System.out.println(inOrderList);
//
//        System.out.println("********* is tree BST *******");
//        System.out.println(isBST(constructTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
//        System.out.println("********* Size of the tree *******");
//        System.out.println(sizeOfTreeRecursive(constructTree()));
//        System.out.println(sizeOfTreeIterative(constructTree()));

//        System.out.println("********* height of the tree *******");
//        System.out.println(heightOfTreeRecursive(constructTree()));
//        System.out.println(heightOfTreeIterative(constructTree()));

//        System.out.println("********* count Leaf nodes of the tree *******");
//        System.out.println(countNumberOfLeafNodesRecursive(constructTree()));
//        System.out.println(countNumberOfLeafNodesIterative(constructTree()));

//        System.out.println("********* diameter of the binary tree dfs *******");
//        System.out.println(diameterOfTree(constructDiameterTree()));
//
//        diameterOfTreeWithGlobalVariable(constructDiameterTree());
//        System.out.println(diameterGlobal);
//
//        final BinaryTree.Height rootHeight = new BinaryTree.Height();
//        getDiameterOfTheTreeByHeightNode(constructDiameterTree(), rootHeight);
//        System.out.println(rootHeight.diameter);

//        System.out.println("********* search in binary tree dfs *******");
//        System.out.println(searchInBinaryTreeRecursive(constructTree(), 18));

//        System.out.println("********* is tree perfect binary tree? *******");
//        System.out.println(isPerfectBinaryTreeIterative(isTreePerfectBinaryTree()));
//        System.out.println(isPerfectBinaryTreeRecursive(isTreePerfectBinaryTree()));

//        System.out.println("********* find maximum of the tree *******");
//        System.out.println(findMax(constructTree()));
//
//        System.out.println("********* Horizontal distance *******");
//        final Map<Integer, LinkedList<Integer>> integerListMap = horizontalDistance(constructDiagonalTraversal());
//        integerListMap.forEach((k, v) -> System.out.println("H distance from root: " + k + " nodes: " + v));
//
//        System.out.println("********* Horizontal distance DFS *******");
//        final Map<Integer, LinkedList<Integer>> integerListMapDFS = horizontalDistanceByDFS(constructDiagonalTraversal());
//        integerListMapDFS.forEach((k, v) -> System.out.println("H distance from root: " + k + " nodes: " + v));
//
//        System.out.println("********* Diagonal Traversal of Binary Tree *********");
//        diagonalPrint(constructDiagonalTraversal());
//        System.out.println("********* Maximum weighted path from root to leaf *******");
//        System.out.println(maximumWeightedRootToLeafPath(longestPathTree()));
//
//        System.out.println("********* Weight of longest path from root to leaf *******");
//        weightOfLongestPathFromRootToLeaf(longestPathTree());
//        System.out.println(ROOT_TO_LEAF_MAX_LEN + " : " + ROOT_TO_LEAF_MAX_SUM);

//        System.out.println("********* is path from root to leaf exists with sum *******");
//        System.out.println(isPathExistsWithSum(constructTree(), 86));

//        System.out.println("********* All paths from root to leaf *******");
//        allPathsFromRootToLeaf(constructTree(), new ArrayList<Integer>(), 0);

//        System.out.println("********* All paths from root to leaf with given sum *******");
//        allPathsFromRootToLeafWithGivenSum(constructTree(), 45, new ArrayList<Integer>(), 0);

//        System.out.println("********* All paths from root with given sum *******");
//        allPathsFromRootWithGivenSum(constructTreeWithSumPath(), 0, 38, new ArrayList<Integer>(), 0);

//        System.out.println("********* Lowest in binary search tree *******");
//        getLowestNodeInBST(constructTree());

//        System.out.println("********* search in a tree *******");
//        System.out.println(searchTree(constructTree(), 20));
//
//        System.out.println("********* find closet in a tree *******");
//        System.out.println(getFloorOfTheNodes(constructTree(), 18));

//        System.out.println("********* are trees symmetric *******");
//        System.out.println(areSymmetricTrees(node1(), node2()));

//        System.out.println("********* zigzag level order traversal *******");
//        final List<List<Integer>> lists = zigzagLevelOrder(constructTree());
//        System.out.println(lists);

//        int[] array = new int[] {4,2,5,1,6,3,7};
//        final TreeNode treeNode = listToBalancedBinaryTree(createListFromArray(array), 0, 7);
//        BFSPrint(treeNode);
//        DFSPrint(treeNode);



//
//        TODO:
        int [] inorder = new int[] {4,2,5,1,3,6};
        int [] preOrder = new int[] {1,2,4,5,3,6};
        int [] postOrder = new int[] {4,5,2,6,3,1};
//        System.out.println("********* Tree from preorder and postorder *******");
//        postOrderTraversal(constructTreeFromInorderAndPreorder(inorder, preOrder, 0, inorder.length-1));
    }


    public void graphFunctionality(){
//        System.out.println("********* BFS traversal in graph *******");
//        graphBFS(0, constructGraph());

//        System.out.println("********* DFS traversal in graph *******");
//        graphDFS(constructGraph());

//        System.out.println("********* Cycle in directed graph *******");
//        System.out.println(isCycleInDirectedGraph(constructDirectedCyclicGraph2()));
//        System.out.println(isCycleInDirectedGraphVersion2(constructDirectedCyclicGraph2()));

//        System.out.println("********* Cycle in directed graph *******");
//        System.out.println(isCycleInDirectedGraph(constructDirectedCyclicGraph()));

//        System.out.println("********* topological sort in directed graph *******");
//        final Stack<Integer> stack = topologicalSort(constructGraph());
//        printStack(stack);
//        System.out.println();

//        System.out.println("********* Path exist from start to end node *******");
//        System.out.println(isPathExists(2, 5, constructGraph()));
//        getPathFromSourceToDest(2, 5, constructGraph());

//        System.out.println("********* Get all path from start node *******");
//        getAllPathFromSource(0, constructGraph());

//        int[][] array = { {1,0}, {2,0} ,{0,1}};
////        System.out.println(canFinish(3, array));
//        System.out.println(canFinishVersion2(4, array));

//        final int[] order = findOrder(2, array);
//        for (int i = 0; i < order.length; i++) {
//            System.out.print(order[i]+" ");
//        }
//        Graph.Employee emp1 = new Graph.Employee();
//        emp1.importance =5;
//        emp1.id=1;
//        emp1.subordinates = Arrays.asList(2,3);
//
//        Graph.Employee emp2 = new Graph.Employee();
//        emp2.importance =3;
//        emp2.id=2;
//        emp2.subordinates = new ArrayList<>();
//
//        Graph.Employee emp3 = new Graph.Employee();
//        emp3.importance =3;
//        emp3.id=3;
//        emp3.subordinates = new ArrayList<>();
//        System.out.println(getImportance(Arrays.asList(emp1,emp2,emp3), 1));
    }

    private void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() +" - ");
        }
    }

    public void arrayFunctionality(){

//        int[] subArrayMaxSum = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
//        System.out.println(findMaximumSubArrayInArray(subArrayMaxSum));

//        int[] subArrayMinSum = new int[] {3, -4, 2, -3, -1, 7, -5};
//        System.out.println(findMinimumSubArrayInArray(subArrayMinSum));


//        int[] maxContiguousSumArray = new int[] {2, 1, 4, 7, 3, 6};
//        System.out.println(largestSumContiguousArray(maxContiguousSumArray));


//        int[] a = new int[] {3,4,-1,0,6,2,3};
//        System.out.println("********* longest common sub sequence *******");
//        System.out.println(longestCommonIncreasingSubSequence(a));
//
//        int[] array = new int[] {1,2,3,4,5,6,7};
//        rotateArrayClockWise(array, 2);
//        printArray(array);
//
//        int[] array2 = new int[] {1,2,3,4,5,6,7};
//        rotateArrayAntiClockWise(array2, 2);
//        printArray(array2);


        List<List<String>> result = getAllCombinations(listOfList(), 3);

        System.out.println("--Result list--");
        for (int i = 0 ; i < result.size();i++) {
            System.out.println(result.get(i));
        }
    }
}
