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

    public void add(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        } else {
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }

    }

    public void addAtFront(int value) {
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }

    }

    public void addInMiddle(int value, int afterLocation){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        } else {
            Node current = head;
            for(int i=1; i<afterLocation;i++){
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

    public void print(){
        Node current = head;
        while(current != null){
            System.out.print(current.getKey()+" - ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void printFromNode(Node start){
        Node current = start;
        while(current != null){
            System.out.print(current.getKey()+" - ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void delete(int value){
        if(head == null)
            return;
        else{
            Node current = head;
            Node prev = null;
            while(current != null){
                if(current.getKey() != value){
                    prev = current;
                    current = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                    current.setNext(null);
                    current = prev.getNext();
                }
            }
        }
    }

    public Node middleElement() {
        if (head == null) {
            return null;
        } else {
            Node fast = head;
            Node slow = head;
            while (fast.getNext().getNext() != null && fast.getNext() != null) {
                fast = fast
                        .getNext()
                        .getNext();
                slow = slow.getNext();
            }
            return slow;
        }
    }

    public static void removeDuplicates(Node head){
        if(head == null)
            return;
        Node prev = head, current = head.getNext();
        Node next = null;
        while (current != null){
            if(prev.getKey() == current.getKey()){
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

    public static Node findIntersectedNode(List<Node> twoIntersectedList) {
        Node big = twoIntersectedList.get(0), small = twoIntersectedList.get(1);
        int lengthOne = length(big);
        int lengthTwo = length(small);


        int diff = lengthOne - lengthTwo;
        if(diff < 0) {
            big = twoIntersectedList.get(1);
            small = twoIntersectedList.get(0);
        }
        for(int i=1; i <= Math.abs(diff); i++){
            big = big.getNext();
        }

        while (big != null && small != null){
            if(big == small){
                return big;
            }
            small = small.getNext();
            big = big.getNext();
        }

        return null;
    }

    public static int length(Node temp){
        if(temp == null)
            return 0;
        int count = 1;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            count++;

        }
        return count;
    }

    public static Node reverseListInPairs(Node head) {
        if(head == null)
            return null;
        Node temp = head;

        while (temp != null && temp.getNext() !=null){
            int k = temp.getKey();
            temp.setKey(temp.getNext().getKey());
            temp.getNext().setKey(k);
            temp = temp.getNext().getNext();
        }
        return head;
    }
}
