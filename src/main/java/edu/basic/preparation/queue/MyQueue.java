package edu.basic.preparation.queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 */
public class MyQueue {

    public static class QueueUsingTwoStacks {

        Stack<Integer> stack1;

        Stack<Integer> stack2;


        public QueueUsingTwoStacks() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /**
         * Add element in queue costly operation O(n)
         */
        public void enQueue(int element) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            stack1.push(element);

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        /**
         * Get queue element, in O(1)
         */
        public int deQueue() {
            if (!stack1.isEmpty()) {
                return stack1.pop();
            }
            throw new NoSuchElementException("MyQueue Empty");
        }

        @Override
        public String toString() {
            return stack1
                    .stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining("-"));
        }
    }


    public static class QueueUsingOneStacks {

        Stack<Integer> stack;

        public QueueUsingOneStacks() {
            this.stack = new Stack<>();
        }

        /**
         * Add element in queue costly operation O(n)
         */
        public void enQueue(int element) {

            stack.push(element);
        }

        /**
         * Get queue element, in O(1)
         */
        public void deQueue() {
            if(stack.isEmpty())
                return;
            else {
                if(stack.size() == 1){
                    System.out.println(stack.pop());
                    return ;
                } else {
                    int data = stack.pop();
                    deQueue();
                    enQueue(data);
                }
            }
        }

        @Override
        public String toString() {
            return stack
                    .stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining("-"));
        }
    }


    public static void priorityQueue() {
        // Creating empty priority queue
        PriorityQueue<String> pQueue = new PriorityQueue<>();

        // Adding items to the pQueue using add()
        pQueue.add("C");
        pQueue.add("C++");
        pQueue.add("Java");
        pQueue.add("Python");

        // Printing the most priority element
        System.out.println("Head value using peek function:"
                + pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        pQueue.forEach(element -> System.out.println(element));

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        System.out.println("Priority element is : "+pQueue.poll());

        System.out.println("After removing an element with poll function: ");
        pQueue.forEach(element -> System.out.println(element));

        // Removing Java using remove()
        pQueue.remove("Java");
        System.out.println("after removing Java with remove function:");
        pQueue.forEach(element -> System.out.println(element));

        // Check if an element is present using contains()
        System.out.println ( "Priority queue contains C or not?: " + pQueue.contains("C"));

        // Getting objects from the queue using toArray()
        // in an array and print the array
        String[] arr = pQueue.toArray(new String[0]);
        System.out.println ( "Value in array: ");
        for (String s : arr) System.out.println("Value: " + s);
    }


    //TreeSet sorted according to length of the string
    public static void treeSet() {
        final Map<String, Integer> map = createMap();

        Set<String> set = new TreeSet<>(new StringLengthComparator());

        map.forEach((k,v) -> set.add(k));

        set.forEach(x -> System.out.println(x));
    }


    /**
     * Stock value problem. Keep stock from high to low value
     *
     * Priority queue implementation
     */
    public static void priorityQueueImplementation() {
        final Map<String, Integer> map = createMap();

        PriorityQueue<Node> pq = new PriorityQueue<>(new DecreasingOrderStockComparator());

        map.forEach((k,v) -> pq.add(new Node(k,v)));

        while (!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    //Node implementation
    public static class Node {
        String name;
        int stock;

        public Node(String name, int stock) {
            this.name = name;
            this.stock = stock;
        }

        @Override
        public String toString() {
            return this.name+" - "+this.stock;
        }
    }

    //Descending order integer
    public static class DecreasingOrderStockComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.stock - o1.stock;
        }
    }

    //input data
    public static Map<String, Integer> createMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("ibm",300);
        map.put("netflix",100);
        map.put("salesforce",150);
        map.put("google",300);
        map.put("vm",50);
        return map;
    }

    //Compare integer decreasing order
    public static class AscendingIntegerComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1 ;
        }
    }

    //Compare length of the string
    public static class StringLengthComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    /**
     * Not sure what was the problem
     *
     * @param list list of elements
     */
    public static List<Integer> splitQueue(List<Integer> list) {

        final int size = list.size();
        int mid = size / 2;

        Stack<Integer> stack = new Stack<>();

        for (int i = mid - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        boolean isStack = true;

        for (int i = 0; i < size; i++) {
            if (!stack.isEmpty() && isStack) {
                list.set(i, stack.pop());
                isStack = false;
            } else {
                list.set(i, list.get(mid++));
                isStack = true;
            }
        }
        return list;
    }
}
