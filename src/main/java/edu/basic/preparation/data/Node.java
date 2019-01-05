package edu.basic.preparation.data;

import lombok.Data;

/**
 * @author Kartik Mahaley
 */
@Data
public class Node {

    public int key;

    public Node next;

    public Node(int key) {
        this.key = key;
    }
}
