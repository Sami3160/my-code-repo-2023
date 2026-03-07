package queue;

public class linkedlist_powered {
    Node start = null;
    Node end = null;
    int size = 0;

    void enqueue(int data) {
        Node node = new Node(data);
        if (size == 0) {
            start = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
        size++;
    }

    int dequeue() {
        if (size == 0)
            return -1;
        if (size == 1) {
            int data = start.data;
            start = null;
            end = null;
            size--;
            return data;
        }
        Node temp = start;
        start = start.next;
        size--;
        temp.next = null;
        return temp.data;
    }

    public static void main(String[] args) {
        linkedlist_powered q = new linkedlist_powered();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue()); // should print 10
        System.out.println(q.dequeue()); // should print 20
        System.out.println(q.dequeue()); // should print 30
        System.out.println(q.dequeue()); // should print -1
    }
}

class Node {
    int data;
    Node next = null;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
