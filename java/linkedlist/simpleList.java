class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }
}

class simpleList {
    Node head;

    public simpleList() {
        head = null;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        Node ptr = head;
        if(index==0){
            return head.val;
        }
        int i = 0;
        while (i < index && ptr != null) {
            ptr = ptr.next;
            i++;
            // System.out.print("[" + ptr.val + "],");
        }
        if(ptr==null)return -1;

        return ptr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head= newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        // newNode.val=val;
        if (head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        // newNode.next = null;
        ptr.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index==0) {
            addAtHead(val);
            // newNode.next = head;
            // head = newNode;
            return;
            // newNode.next=null;
        }
        Node newNode = new Node(val);
        
        Node ptr = head;
        int i = 0;
        while (i < index-1 && ptr != null) {
            ptr = ptr.next;
            i++;
        }

        if(ptr==null)return;
        newNode.next = ptr.next;
        ptr.next = newNode;

        // ptr
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node ptr = head;
        int i = 0;
        while (i < index - 1 && ptr != null) {
            ptr = ptr.next;
            i++;
        }
        if (ptr == null || ptr.next == null) {
            return;
        }
        ptr.next = ptr.next.next;
    }



    public void display() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + "->");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        simpleList obj = new simpleList();
        int param_1 = obj.get(10);
        // obj.addAtHead(1);
        // obj.addAtTail(3);
        obj.addAtIndex(1,0);
        obj.display();
        System.out.println(obj.get(0));
        // obj.deleteAtIndex(1);
        // System.out.println(obj.get(1));

        // obj.addAtIndex(1, 2);
        // obj.addAtTail(3);
        // obj.addAtIndex(1,8);
        // obj.deleteAtIndex(1);
        // obj.deleteAtIndex(6);
        // System.out.println(obj.get(0));
        obj.display();

        // obj.display();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */