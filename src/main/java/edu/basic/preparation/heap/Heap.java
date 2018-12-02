package edu.basic.preparation.heap;

import java.util.Arrays;

import lombok.Data;

public class Heap {

    @Data
    public static class MinHeap {
        int capacity =10;

        int[] items = new int[capacity] ;

        int size = 0;

        public int getParentIndex(int index) { return (index - 1) / 2; }

        public int getLeftChildIndex(int index) { return 2 * index + 1; }

        public int getRightChildIndex(int index) { return 2 * index + 2; }

        public boolean hasParent(int index) {  return getParentIndex(index) >= 0; }

        public boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }

        public boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }

        public int getParent(int index) {  return items[getParentIndex(index)]; }

        public int getLeftChild(int index) { return items[getLeftChildIndex(index)]; }

        public int getRightChild(int index) { return items[getRightChildIndex(index)]; }

        public void swapIndexValues(int x, int y) {
            int temp = items[x];
            items[x] = items[y];
            items[y] = temp;
        }

        public void increaseSize() {
            if (size == capacity) {
                capacity = capacity * 2;
                items = Arrays.copyOf(items, capacity);
            }
        }

        public void add(int ele) {
            increaseSize();
            items[size] = ele;
            size++;
            heapifyUp();
        }

        private void heapifyUp() {
            int index = size - 1;

            while (hasParent(index) && getParent(index) > items[index]) {
                final int parentIndex = getParentIndex(index);
                swapIndexValues(index, parentIndex);
                index = parentIndex;
            }
        }

        public int peek() {
            if (size == 0) throw  new IllegalStateException("empty heap");
            return items[0];
        }

        public int poll() {
            if (size == 0) {
                throw new IllegalStateException("empty heap");
            }
            int value = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return value;
        }

        private void heapifyDown() {
            int index = 0;

            while (hasLeftChild(index)) {
                //get smaller index from left and right child
                int smallerIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getLeftChild(index) > getRightChild(index)) {
                    smallerIndex = getRightChildIndex(index);
                }

                if(items[index] < items[smallerIndex]){
                    break;
                } else{

                    swapIndexValues(index, smallerIndex);
                }
                index = smallerIndex;
            }
        }

    }

}
