package edu.basic.preparation.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Stack;
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



}
