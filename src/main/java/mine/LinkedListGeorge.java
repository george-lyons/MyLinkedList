package mine;

import lombok.Data;

import java.util.NoSuchElementException;


/**
 * Created by georgelyons
 * <p>
 * In  a linked list we store an object
 * <p>
 * for purposes of this task - writing linkedlist, we will store an int on each node, would be generic any object
 * <p>
 * we need to be able to loop through and get a Node at any index - method for this
 */
public class LinkedListGeorge {

    Integer size;
    Node head;
    Node tail;

    LinkedListGeorge() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    //we need to find the node, add then shift the whole list - hence O(N)
    public void add(Integer data, int index) {
        assert index <= size && index >= 0;
        if (index == 0) {
            // add head
            addFirst(data);
        } else if (index == size) {
            //add to tail - one after final incex
            add(data);
        } else {
            //put into method add to middle index
            addMiddle(data, index);
        }
    }


    //insert in middle of the LL - getNode
    private void addMiddle(Integer data, int index) {
        Node toAddAtIndex = new Node(data);
        //put into method add to middle index
        Node prev = getNode(index - 1);
        Node next = prev.next;

        prev.next = toAddAtIndex;
        toAddAtIndex.previous = prev;
        toAddAtIndex.next = next;
        next.previous = toAddAtIndex;
        size++;
    }

    //add to head - usually remove here
    private void addFirst(Integer data) {
        Node add = new Node(data);

        if(head == null) {
            assert size == 0;
            head = add;
            tail = add;
        } else {

            Node prevHead = head;
            head = add;
            prevHead.previous = head;
            head.next = prevHead;
        }
        size++;
    }

    //we need to find the node and remove, then shift the whole list - hence O(N)
    public int remove(int index) {
        assert index <= size && index >= 0;

        //todo remove at head and tail cases, this is middle
        Node toRemove = getNode(index);

        if(index == 0 && toRemove == head) {
            //assert same as to remove
            removeFirst();
        } else if (index == size -1 && toRemove == tail) {
            //assert same as to remove
            removeLast();
        } else {
            Node linkLeft = toRemove.previous;
            Node linkRight = toRemove.next;
            linkLeft.next = linkRight;
            linkRight.previous = linkLeft;
        }

        size--;
        return toRemove.data;
    }


    //O(1) to add tail of linkedlist
    public boolean add(Integer data) {
        //add to end of list
        Node newNode = new Node(data);
        //nothing in list if tail is null
        if (tail == null) {
            //should be empty
            assert size == 0;
            tail = newNode;
            head = newNode;
            //no references as one node
        } else {
            Node prevLast = tail;
            tail = newNode;
            prevLast.next = newNode;
            tail.previous = prevLast;
        }
        size++;
        return true;
    }

    //O(1) remove head of list
    public Integer removeFirst() {
        Node nodeToRemove = head;
        if (nodeToRemove == null) {
            //empty list implied
            throw new NoSuchElementException();
        } else {
            //new head is next node
            head = nodeToRemove.next;
            if (head == null) {
                //empty now so also tail null
                tail = null;
            } else {
                head.previous = null;
            }
        }
        size--;
        return nodeToRemove.data;
    }

    public int removeLast() {
        Node nodeToRemove = tail;
        if(nodeToRemove == null) {
            throw new NoSuchElementException();
        } else {
            tail = nodeToRemove.previous;
            if(tail == null) {
                //empty now so also head null
                head = null;
            } else {
                //nohting after
                tail.next = null;
            }
        }
        size--;
        return nodeToRemove.data;
    }

    public int remove() {
        //get and remove first element of list
        return removeFirst();
    }

    //this is O(N) to get Node in middle
    //can improve by going from tail or head based on where it is - which half of the list - rather than searching across
    private Node getNode(int index) {
        //assert index - done in get
        Node x = head;
        if (index < size - 1 && index > 0) {
            //start 1 to index
            for (int i = 1; i <= index; i++) {
                x = x.next;
            }
            return x;
        } else if (index == 0) {
            return head;
        } else if (index == size - 1) {
            return tail;
        }
        throw new NoSuchElementException();
    }


    private Node getNodeFromEitherSide(int index) {

        throw new NoSuchElementException();
    }


    public Integer get(int index) {
        assert index < size && index >= 0;
        return getNode(index).data;
    }

    //basically an iterator and print the LL in tests
    public void prettyPrintConsole() {
        // print the linked list state for tests - loop through and print
        // Node becomes a pointer with ref to each part and loops through
        Node x = head;
        System.out.println("--");
        System.out.println("--");
        System.out.print("||");
        if (size > 0 && head != null) {
            System.out.print(x.data);
            for (int i = 0; i < size; i++) {
                Node current = x;
                x = x.next;
                if (x != null) {
                    System.out.print("||");
                    System.out.print(x.data);
                } else {
                    //when null implies we are at tail - check same memory allocation
                    assert current == tail;
                }
            }
            System.out.print("|");
        }
    }


    /*
    Create a list iterator
     */


    @Data
    class Node {
        //contains here
        Integer data;
        //next data
        Node next;
        //previous data
        Node previous;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

    }
}
