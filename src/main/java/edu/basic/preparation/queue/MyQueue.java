package edu.basic.preparation.queue;

import java.util.NoSuchElementException;
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




}
