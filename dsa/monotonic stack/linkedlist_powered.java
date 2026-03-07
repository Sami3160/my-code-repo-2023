class Node{
    int data;
    Node next=null;
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class linkedlist_powered{
    Node top=null;
    int size=0;
    void push(int data){    
        Node node=new Node(data);
        node.next=top;
        top=node;
        size++;
    }

    int pop(){
        Node temp=top;
        top=top.next;
        temp.next=null;
        size--;
        return temp.data;
    }


    int size(){
        return size;
    }

    int top(){
        if(top==null){
            System.out.println("stack is empty");
            return -1;
        }
        return top.data;
    }

    boolean isEmpty(){
        return top==null;
    }
    public static void main(String[] args) {
        linkedlist_powered l1=new linkedlist_powered();
        l1.push(0);
        l1.push(2);
        l1.push(3);
        System.out.println(l1.top());
        l1.pop();
        System.out.println(l1.top());
        l1.pop();
        System.out.println(l1.top());
        l1.pop();
        System.out.println(l1.top());
    }
}