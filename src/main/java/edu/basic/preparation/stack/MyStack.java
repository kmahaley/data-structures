package edu.basic.preparation.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Kartik Mahaley
 */
public class MyStack {

    public static class StackUsingTwoQueue {

        Queue<Integer> queue1;

        Queue<Integer> queue2;

        public StackUsingTwoQueue() {
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
        int size = a.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("_ ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            stack.push(a[i]);
        }
        System.out.println();
    }
}
