package edu.basic.preparation.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
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
        PriorityQueue<String> pQueue =
                new PriorityQueue<String>();

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
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("After removing an element" +
                "with poll function:");
        Iterator<String> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());

        // Removing Java using remove()
        pQueue.remove("Java");
        System.out.println("after removing Java with" +
                " remove function:");
        Iterator<String> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());

        // Check if an element is present using contains()
        boolean b = pQueue.contains("C");
        System.out.println ( "Priority queue contains C " +
                "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pQueue.toArray();
        System.out.println ( "Value in array: ");
        for (int i = 0; i<arr.length; i++)
            System.out.println ( "Value: " + arr[i].toString()) ;
    }



    //TreeSet sorted according to length of the string
    public static void setImplementation() {
        final Map<String, Integer> map = createMap();

        Set<String> set = new TreeSet<>(new StringLengthComparator());
        map.forEach((k,v) -> set.add(k));

        set.forEach(x -> System.out.println(x));
    }

    //Priority queue implementation
    public static void priorityQueueImplementation() {
        final Map<String, Integer> map = createMap();

        PriorityQueue<Node> pq = new PriorityQueue<>(10, new DecreasingOrderStockComparator());

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

    //Stock with
    public static void mapImplementation() {
        Map<String, Integer> map = createMap();

        Map<Integer, List<String>> treeMap = new TreeMap<>(new AscendingIntegerComparator());
        map.forEach((name,stock) -> {
            if(treeMap.containsKey(stock)){
                final List<String> strings = treeMap.get(stock);
                strings.add(name);
                treeMap.put(stock, strings);

            } else {
                List<String> list = new ArrayList<>();
                list.add(name);
                treeMap.put(stock, list);
            }
        });

        System.out.println(treeMap);
        int count = 0;

        for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()){
            if(count < 3){
                final List<String> value = entry.getValue();
                for (String s : value){
                    if(count < 3){
                        System.out.println(s);
                    }
                    count++;
                }
            }
        }
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
}
