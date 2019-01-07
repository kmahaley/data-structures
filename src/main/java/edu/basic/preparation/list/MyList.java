package edu.basic.preparation.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
            while (current.next != null) {
                current = current.next;
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
                current = current.next;
            }
            newNode.setNext(current.next);
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
                next = current.next;
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
            current = current.next;
        }
        System.out.println();
    }

    public static void printFromNode(Node start) {
        Node current = start;
        while (current != null) {
            System.out.print(current.getKey() + " - ");
            current = current.next;
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
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null) {

            if (current.getKey() != value) {
                prev = current;
                current = current.next;
            } else {
                prev.setNext(current.next);
                current.setNext(null);
                current = prev.next;
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
            head = head.next;
            return;
        }
        Node temp = head, prev = null;
        //Search until you get the element
        while (temp != null && temp.getKey() != element){
            prev = temp;
            temp = temp.next;
        }
        //element not in the list
        if(temp == null)
            return;

        prev.setNext(temp.next);

    }

    public Node middleElement() {
        if (head == null) {
            return null;
        } else {
            Node fast = head;
            Node slow = head;
            while (fast.next.next != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    public static void removeDuplicates(Node head) {
        if (head == null) {
            return;
        }
        Node prev = head, current = head.next;
        Node next;
        while (current != null) {
            if (prev.getKey() == current.getKey()) {
                next = current.next;
                current.setNext(null);
                current = next;
                prev.setNext(current);
            } else {
                prev = prev.next;
                current = current.next;
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
            big = big.next;
        }

        while (big != null && small != null) {
            if (big == small) {
                return big;
            }
            small = small.next;
            big = big.next;
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
        while (temp.next != null) {
            temp = temp.next;
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
        return getLengthRecursive(temp.next, length + 1);
    }

    /**
     * Length of the linked list
     */
    public static int getLengthRecursive2(Node temp) {
        if (temp == null) {
            return 0;
        }
        return 1 + getLengthRecursive2(temp.next);
    }

    public static Node reverseListInPairs(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;

        while (temp != null && temp.next != null) {
            int k = temp.getKey();
            temp.setKey(temp
                    .next
                    .getKey());
            temp
                    .next
                    .setKey(k);
            temp = temp.next.next;
        }
        return head;
    }

    public static Node recursiveReverseLinkedList(Node head, Node prev){
        if(head == null)
            return prev;

        final Node next = head.next;
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
        return searchRecursive(head.next, data);

    }

    public static int getElementIndexPosition(Node head, int data, int index) {

        if (head == null) {
            return -1;
        }
        if (head.getKey() == data) {
            return index;
        }
        return getElementIndexPosition(head.next, data, index + 1);
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
            fast = fast.next;
            i++;
        }

        //pos is greater than length of the linked list
        if (fast == null) {
            return -1;
        }
        //move fast and slow step by steps
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.getKey();

    }

    public static Node deleteAllOccurencesOfNode(Node head, int element) {

        if (head == null) {
            return null;
        }

        Node prev = null, curr = head;

        while (curr != null) {
            if (curr.getKey() == element) {
                Node next = curr.next;
                //if first node is to be deleted
                if(prev == null){
                    curr.setNext(null);
                    curr = next;
                    head = curr;
                } else {
                    prev.setNext(next);
                    curr = next;
                }

            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    //Remove Nth Node From End of List.
    public Node removeNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }

        Node fast = head, slow = head, prev = head;

        for (int i = 1; i < n && fast != null; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == slow) {
            head = head.next;
        } else {
            prev.next = slow.next;
        }


        return head;

    }


    /**
     * Delete current node from the list
     */
    public static void deleteNode(Node node) {

        if(node == null){
            return;
        }
        Node curr = node;

        while(node.next.next != null) {
            node.key = node.next.key;
            node = node.next;

        }
        node.key = node.next.key;
        node.next = null;

    }

    /**
     * List contains cycle or not
     */
    public boolean hasCycle(Node head) {

        if(head == null){
            return false;
        }
        Node slow = head, fast = head.next;

        while(fast != null && fast.next !=null){

            if(slow == fast) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;

    }

    /**
     * Merge two sorted list
     *
     * @param l1 list 1
     * @param l2 list 2
     * @return start of new list
     */
    public static Node mergeTwoLists(Node l1, Node l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node newList = null;
        Node first = l1, second = l2;

        if (first.key <= second.key) {
            newList = new Node(first.key);
            first = first.next;
        } else {
            newList = new Node(second.key);
            second = second.next;
        }

        Node curr = newList;

        while (first != null && second != null) {

            if (first.key <= second.key) {
                curr.next = new Node(first.key);
                first = first.next;
            } else {
                curr.next = new Node(second.key);
                second = second.next;
            }
            curr = curr.next;
        }

        while (first != null) {
            curr.next = new Node(first.key);
            first = first.next;
            curr = curr.next;
        }

        while (second != null) {
            curr.next = new Node(second.key);
            second = second.next;
            curr = curr.next;
        }

        return newList;
    }

    /**
     * Check if list contain a palindrome number
     */
    public boolean isPalindrome(Node head) {

        if(head == null) {
            return true;
        }

        int count =1;
        Node curr = head;
//      Get count
        while(curr.next != null) {
            count++;
            curr= curr.next;
        }

        int mid = count/2;
        curr = head;
        for(int i=0; i<mid; i++){
            curr= curr.next;
        }
//      Check or even or odd
        if(count%2 != 0){
            curr = curr.next;
        }
//      save second half in stack
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            st.push(curr.key);
            curr= curr.next;
        }

        Node start = head;

        for(int j=0; j<mid; j++) {
            int top = st.pop();
            if(start.key != top) {
                return false;
            }
            start= start.next;
        }

        return true;
    }

    /**
     * Detect cycle, if cycle exists return start node of the cycle else return null.
     *
     */
    public Node detectCycle(Node head) {

        if(head == null){
            return null;
        }
        Node slow= head, fast= head;
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }

        Node start = fast;
        int count =1;
        while(start.next != fast) {
            start = start.next;
            count ++;
        }
        int i=1;
        Node x= head, y= head;
        while(i<= count) {
            x = x.next;
            i++;
        }

        while(x !=  y) {
            x= x.next;
            y= y.next;
        }
        return x;

    }

    /**
     * Remove duplicate elements from the list
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */
    public Node deleteDuplicates(Node head) {

        if(head == null || head.next == null){
            return head;
        }
        Node prev = head, curr = head.next;
        while(curr != null){

            if(prev.key == curr.key){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

    /**
     * Keep unique element in the list
     *
     * Input: 1->1->1->2->3
     * Output: 2->3
     *
     * @param head head
     * @return head
     */
    public static Node keepUniqueNodes(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node curr = head, prev = null;
        Map<Integer, Integer> map = new HashMap<>();
        while(curr != null) {
            int element = curr.key;
            if(map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element,1);
            }
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node next = curr.next;
            int ele = curr.key;

            if(map.get(ele) > 1) {
                if(curr == head) {
                    head = next;
                } else {
                    prev.next = next;
                }
            } else {
                prev = curr;
            }
            curr = next;
        }
        return head;
    }

    /**
     * Reverse list between two pointers
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     *  faster solution is in method reverseBetweenOptimized
     *
     * @param head head
     * @param m start
     * @param n end
     * @return start
     */
    public Node reverseBetween(Node head, int m, int n) {

        if(head == null || head.next == null || m >= n){
            return head;
        }

        int c = 1;
        Node curr = head;
        Stack<Integer> st = new Stack<>();

        while(curr !=null && c <= n) {
            if(c >= m && c <= n) {
                st.push(curr.key);
            }
            c++;
            curr = curr.next;
        }
        c=1;
        curr = head;
        while(curr !=null && c <= n) {
            if(c >= m && c <= n) {
                curr.key = st.pop();
            }
            c++;
            curr = curr.next;
        }
        return head;
    }

    /**
     * Reverse list between two pointers
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     *
     * @param head head
     * @param m start
     * @param n end
     * @return start
     */
    public static Node reverseBetweenOptimized(Node head, int m, int n) {

        if(head == null || head.next == null || m >= n){
            return head;
        }

        int c = 1;
        Node curr = head, start=null, end=null, before= null, after= null;

        while(curr !=null && c <= n+1) {
            Node next = curr.next;
            if(c == m-1) {
                before = curr;
                before.next = null;
            }
            if(c == m) {
                start = curr;
            }
            if(c == n) {
                end = curr;
                end.next= null;
            }
            if(c == n+1) {
                after = curr;
            }
            c++;
            curr = next;
        }

        Node reverse = reverse(start);
        Node endOfReverseList = endOfReverseList(start);

        if (after != null) {
            endOfReverseList.next = after;
        }

        if (before != null) {
            before.next = reverse;
            return head;
        } else {
            return reverse;
        }
    }

    public static Node reverse(Node node) {
        Node prev = null, current = node, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node endOfReverseList(Node node) {
        Node curr = node;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }


    /**
     * group all odd nodes together followed by the even nodes. odd and even based on indexes.
     *
     * Input: 2->1->3->5->6->4->7->NULL
     * Output: 2->3->6->7->1->5->4->NULL
     *
     * @param head head
     * @return head
     */
    public Node oddEvenList(Node head) {

        if(head == null || head.next == null) {
            return head;
        }
        Node odd =null, oddStart = null, even= null, evenStart=null;
        Node curr= head, next = null;
        boolean oddFlag = true;
        while(curr !=null) {
            next = curr.next;

            if(oddFlag) {
                if(oddStart == null) {
                    oddStart = curr;
                    odd = curr;
                } else {
                    odd.next = curr;
                    odd = odd.next;
                }
                oddFlag= false;
            } else {
                if(evenStart == null) {
                    evenStart = curr;
                    even = curr;
                } else {
                    even.next = curr;
                    even = even.next;
                }
                oddFlag = true;
            }
            curr = next;
        }

        odd.next = evenStart;
        even.next = null;
        return head;

    }
}
