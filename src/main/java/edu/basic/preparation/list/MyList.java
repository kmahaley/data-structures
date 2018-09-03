package edu.basic.preparation.list;

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

    public void print(Node start){
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
}
