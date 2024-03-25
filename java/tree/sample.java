class Node{
    int val;
    Node left, right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}


class Tree{
    Node root;

    public void add(int val){
        // if (root==null) {
        //     root =new Node(val);
        // }else if (val< root.val) {
        //     root.left.val=val;
        //     root.left= new Node(val);
        // }else{
        //     root.right.val=val; 
        //     root.right= new Node(val);  
            
        // }
            root=addRec(root, val);
    }

    public static Node addRec(Node root, int val){
        if(root==null){
            return new Node(val);
        }
        else if(val<root.val){
            root.left=addRec(root.left, val);
        }
        else{
            root.right= addRec(root.right, val);
        }
        return root;
    }
    
    public void inOrder(){
        inOrderRec(root);
    }

    public void inOrderRec(Node node){
        if(node != null){
            inOrderRec(node.left);
            System.out.print(node.val + " ");
            inOrderRec(node.right);
        }
    }
}


public class sample{
    public static void main(String[] args) {
        Tree tr=new Tree();
        tr.add(10);
        tr.add(20);
        tr.add(5);
        tr.add(8);
        tr.add(18);
        tr.addRec(tr.root , 0);
        System.out.println();
        tr.inOrderRec(tr.root);
    }
}