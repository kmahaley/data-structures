package edu.basic.preparation.data;

import lombok.Data;

/**
 * @author Kartik Mahaley
 */
@Data
public class Node {

    private int key;
    private Node next;

    public Node(int key) {
        this.key = key;
    }
}
