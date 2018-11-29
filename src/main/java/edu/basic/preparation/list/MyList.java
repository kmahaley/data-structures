package edu.basic.preparation.list;

import java.util.List;

import edu.basic.preparation.data.Node;
import lombok.Data;

/**
 * @author Kartik Mahaley
 */
@Data
public class MyList {

    private Node head;

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

    }

    public void addAtFront(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }

    }

    public void addInMiddle(int value, int afterLocation) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < afterLocation; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public Node reverse() {
        if (head == null) {
            return null;
        } else {
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
            }
            return prev;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getKey() + " - ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void printFromNode(Node start) {
        Node current = start;
        while (current != null) {
            System.out.print(current.getKey() + " - ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * This will delete node with given value
     *
     * @param value value
     */
    public void delete(int value) {

        if (head == null) {
            return;
        }
        //if element is first to be deleted
        if(head.getKey() == value){
            head = head.getNext();
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null) {

            if (current.getKey() != value) {
                prev = current;
                current = current.getNext();
            } else {
                prev.setNext(current.getNext());
                current.setNext(null);
                current = prev.getNext();
                break;
            }
        }

    }

    /**
     * Just delete single element
     *
     * @param head head
     * @param element to be deleted
     */
    public static void deleteOneNode(Node head, int element){

        if(head == null){
            return;
        }

        if(head.getKey() == element){
            head = head.getNext();
            return;
        }
        Node temp = head, prev = null;
        //Search until you get the element
        while (temp != null && temp.getKey() != element){
            prev = temp;
            temp = temp.getNext();
        }
        //element not in the list
        if(temp == null)
            return;

        prev.setNext(temp.getNext());

    }

    public Node middleElement() {
        if (head == null) {
            return null;
        } else {
            Node fast = head;
            Node slow = head;
            while (fast.getNext().getNext() != null && fast.getNext() != null) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }
            return slow;
        }
    }

    public static void removeDuplicates(Node head) {
        if (head == null) {
            return;
        }
        Node prev = head, current = head.getNext();
        Node next;
        while (current != null) {
            if (prev.getKey() == current.getKey()) {
                next = current.getNext();
                current.setNext(null);
                current = next;
                prev.setNext(current);
            } else {
                prev = prev.getNext();
                current = current.getNext();
            }
        }
        printFromNode(head);
    }

    /**
     * Intersection of two linked list
     *
     * @param twoIntersectedList list with two nodes
     * @return intersecting node
     */
    public static Node findIntersectedNode(List<Node> twoIntersectedList) {
        Node big = twoIntersectedList.get(0), small = twoIntersectedList.get(1);
        if(big == null || small == null){
            return null;
        }
        int lengthOne = length(big);
        int lengthTwo = length(small);


        int diff = lengthOne - lengthTwo;
        if (diff < 0) {
            big = twoIntersectedList.get(1);
            small = twoIntersectedList.get(0);
        }
        for (int i = 1; i <= Math.abs(diff); i++) {
            big = big.getNext();
        }

        while (big != null && small != null) {
            if (big == small) {
                return big;
            }
            small = small.getNext();
            big = big.getNext();
        }

        return null;
    }

    /**
     * Length of the linked list
     */
    public static int length(Node temp) {
        if (temp == null) {
            return 0;
        }
        int count = 1;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            count++;

        }
        return count;
    }


    /**
     * Length of the linked list
     */
    public static int getLengthRecursive(Node temp, int length) {
        if (temp == null) {
            return length;
        }
        return getLengthRecursive(temp.getNext(), length + 1);
    }

    /**
     * Length of the linked list
     */
    public static int getLengthRecursive2(Node temp) {
        if (temp == null) {
            return 0;
        }
        return 1 + getLengthRecursive2(temp.getNext());
    }

    public static Node reverseListInPairs(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;

        while (temp != null && temp.getNext() != null) {
            int k = temp.getKey();
            temp.setKey(temp
                    .getNext()
                    .getKey());
            temp
                    .getNext()
                    .setKey(k);
            temp = temp
                    .getNext()
                    .getNext();
        }
        return head;
    }

    public static Node recursiveReverseLinkedList(Node head, Node prev){
        if(head == null)
            return prev;

        final Node next = head.getNext();
        head.setNext(prev);
        prev = head;
        head = next;
        return recursiveReverseLinkedList(head, prev);
    }

    public static boolean searchRecursive(Node head, int data) {
        if (head == null) {
            return false;
        }
        if (head.getKey() == data) {
            return true;
        }
        return searchRecursive(head.getNext(), data);

    }

    public static int getElementIndexPosition(Node head, int data, int index) {

        if (head == null) {
            return -1;
        }
        if (head.getKey() == data) {
            return index;
        }
        return getElementIndexPosition(head.getNext(), data, index + 1);
    }


    /**
     *
     * @param head start
     * @param pos nth node from last
     * @return nth node
     */
    public static int getNthNodeFromLinkedList(Node head, int pos) {

        if (head == null) {
            return -1;
        }

        Node slow = head, fast = head;
        int i = 1;

        while (fast != null && i < pos) {
            fast = fast.getNext();
            i++;
        }

        if (fast == null) {
            return -1;
        }
        while (fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow.getKey();

    }
}
