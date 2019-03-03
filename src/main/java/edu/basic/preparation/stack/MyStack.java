package edu.basic.preparation.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Kartik Mahaley
 */
public class MyStack {

    /**
     * Stack using priority queue structure
     */
    public static class StackUsingPriorityQueue {

        PriorityQueue<PriorityNode> priorityQueue = new PriorityQueue<>(new PriorityNodeComparator());

        public void push(int data, int priority) {
            PriorityNode node = new PriorityNode(data, priority);
            priorityQueue.add(node);
        }


        public void pop() {
            final PriorityNode poppedNode = priorityQueue.poll();
            System.out.println("Data : " + poppedNode.data + " priority : " + poppedNode.priority);
        }

        public boolean isEmpty() {
            return priorityQueue.isEmpty();
        }

        public int peek() {
            if (!isEmpty()) {

                return priorityQueue.peek().data;
            }
            return -1;
        }

    }

    /**
     * Node for priority queue
     */
    public static class PriorityNode {
        int data;
        int priority;

        public PriorityNode(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    /**
     * comparator for PriorityNode
     */
    public static class PriorityNodeComparator implements Comparator<PriorityNode> {

        @Override
        public int compare(PriorityNode o1, PriorityNode o2) {
            return o2.priority - o1.priority;
        }
    }

    public static class StackUsingTwoQueue {

        Queue<Integer> queue1;

        Queue<Integer> queue2;

        public StackUsingTwoQueue() {
            //you can use ArrayDeque<>() too
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int element) {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }

            queue1.add(element);

            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }

        public int pop() {
            if (!queue1.isEmpty()) {
                return queue1.remove();
            }
            throw new NoSuchElementException("Stack empty");
        }

        @Override
        public String toString() {
            return queue1
                    .stream()
                    .map(no -> no.toString())
                    .collect(Collectors.joining("-"));
        }
    }

    /**
     * Find nearest smaller number in left of the array
     * example {1, 3, 0, 2, 5}
     * ANS => _, 1, _, 0, 2,
     *
     * @param a array
     */
    public static void nearestSmallerNumberOnLeft(int a[]) {
        Stack<Integer> stack = new Stack<>();

        for (int current : a) {

            while (!stack.isEmpty() && stack.peek() >= current) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("_ ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            stack.push(current);
        }
        System.out.println();
    }

    /**
     * Find next smallest number
     * example {1, 3, 0, 2, 5}
     * ANS => 1->0, 3->0, 0->-1 ...
     *
     * @param a array
     */
    public static void nextSmallestElement(int a[]) {
        int length = a.length;
        Stack<Integer> stack = new Stack<>();

        stack.push(a[0]);
        for (int i = 1; i < length; i++) {

            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                System.out.print(stack.pop() + " -> " + a[i] + ", ");
            }

            stack.push(a[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> -1, ");
        }
        System.out.println();
    }

    /**
     * Find next greatest number
     * example {1, 3, 0, 2, 5}
     * ANS => 1->3, 3->5, 0->-2 ...
     *
     * @param a array
     */
    public static void nextGreatestElement(int a[]) {
        int length = a.length;
        Stack<Integer> stack = new Stack<>();

        stack.push(a[0]);
        for (int i = 1; i < length; i++) {

            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                System.out.print(stack.pop() + " -> " + a[i] + ", ");
            }

            stack.push(a[i]);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> -1, ");
        }
        System.out.println();
    }

    /**
     * Reverse a stack using recursion
     *
     * @param stack input stack
     */
    public static void sortStack(Stack<Integer> stack) {

        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            insertIntoSortedStack(stack, x);
        }
    }

    /**
     * Insert into sorted stack
     *
     * @param stack stack
     * @param x insert element in sorted stack
     */
    private static void insertIntoSortedStack(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
        } else {
            int a = stack.pop();
            insertIntoSortedStack(stack, x);
            stack.push(a);
        }
    }

    /**
     * Reverse stack using recursive option
     *
     * @param stack stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, x);
        }
    }

    /**
     * Insert element at bottom
     *
     * @param stack stack
     * @param x insert current at bottom
     */
    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int a = stack.pop();
            insertAtBottom(stack, x);
            stack.push(a);
        }
    }


    /**
     * length of valid parenthesis
     *
     * @param str "()(()))))"
     * @return size
     */
    public static int longestParenthesisString(String str) {

        final char[] toCharArray = str.toCharArray();
        Stack<Character> st = new Stack<>();
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            if (!st.isEmpty() && st.peek() == '(' && toCharArray[i] == ')') {
                newStr = newStr + st.pop() + toCharArray[i];
            } else {
                st.push(toCharArray[i]);
            }
        }
        return newStr.length();
    }


    /**
     * is valid parenthesis
     *
     * @param str "()[{[]}]"
     * @return boolean
     */
    public static boolean isValidParenthesis(String str) {

        final char[] toCharArray = str.toCharArray();
        Stack<Character> st = new Stack<>();
        final List<Character> opening = Arrays.asList(')', '}', ']');
        final List<Character> closing = Arrays.asList('(', '{', '[');

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < str.length(); i++) {

            final char curr = toCharArray[i];
            if(map.entrySet().contains(curr)) {
                st.push(curr);
            } else if (map.values().contains(curr)) {
                if(!st.empty() && map.get(st.peek()) == curr){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.empty();
    }


    /**
     * recursively remove middle element
     *
     * @param st stack
     * @param size stack size
     * @param index index of current
     */
    public static void deleteMiddleElement(Stack<Integer> st, int size, int index) {
        if (st.isEmpty()) {
            return;
        }
        Integer a = null;
        final int stackSize = size / 2;

        if (index >= stackSize) {
            a = st.pop();
        } else {
            return;
        }

        deleteMiddleElement(st, size, index - 1);

        if (index != stackSize && a != null) {
            st.push(a);
        }
    }

    /**
     * Sort a stack using iteratively
     *
     * @param original stack
     * @return stack
     */
    public static Stack<Integer> sortStackIteratively(Stack<Integer> original) {

        if (original.isEmpty()) {
            return original;
        }

        Stack<Integer> aux = new Stack<>();
        while (!original.isEmpty()) {

            final Integer current = original.pop();
            while (!aux.isEmpty() && aux.peek() > current) {
                original.push(aux.pop());
            }
            aux.push(current);
        }
        return aux;
    }


    /**
     * reverse a number
     * @param no number
     * @return reverse number
     */
    public static int reverseNumber(int no) {
        if (no < 10) {
            return no;
        }
        Stack<Integer> stack = new Stack<>();

        while (no > 0) {
            stack.push(no % 10);
            no = no / 10;
        }

        int rev = 0, digitMultiplier = 1;
        while (!stack.isEmpty()) {
            rev = rev + stack.pop() * digitMultiplier;
            digitMultiplier = digitMultiplier * 10;
        }
        return rev;
    }

    /**
     * Max stack implementation
     *
     * input : {8,7,4,3,9}
     * linked list implementation : 9|9 -> 3|8 -> 4|8 -> 7|8-> 8|8
     */
    public static class MaxStackClass {

        public MaxClassNode head;
        public MaxClassNode max;

        public void push(int data) {

            MaxClassNode node = new MaxClassNode(data);
            node.oldMaxNode = max;
            if(max == null || max.data < data) {
                max = node;
            }
            node.next = head;
            head = node;
        }

        public MaxClassNode pop() {
            MaxClassNode popped = null;
            if(head != null) {
                popped = head;
                head = head.next;
                max = head.oldMaxNode;
            }
            return popped;
        }

        public MaxClassNode getMax() {
            return max;
        }

        @Override
        public String toString() {

            StringBuilder builder = new StringBuilder();
            if (head != null) {
                MaxClassNode temp = head;
                while (temp != null) {
                    builder.append(temp.data + " - ");
                    temp = temp.next;
                }
            }
            return builder.toString();
        }
    }

    /**
     * Class to keep track of maximum node and next node in linked list
     */
    public static class MaxClassNode {
        public int data;
        public MaxClassNode next;
        public MaxClassNode oldMaxNode;

        public MaxClassNode(int data) {
            this.data = data;
        }

    }
}
