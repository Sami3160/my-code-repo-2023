import java.util.Scanner;

public class BinaryTree {
    public BinaryTree(){

    }   
    
    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;

        }
    
    
    }

    private Node root=null;


    public void pupulate(Scanner sc){
        System.out.println("Enter the root node val : ");
        int value=sc.nextInt();
        root=new Node(value);
        populate(sc, root);
        System.out.println("The tree is created");
    }
    public void populate(Scanner sc,Node root){
        System.out.println("Do oyu want to enter left of "+root.value);
        boolean left= sc.nextBoolean();
        if(left){
            System.out.println("Enter the left node val : ");
            int value=sc.nextInt();        
            root.left=new Node(value);
            populate(sc, root.left);
        }

        
        System.out.println("Do you want to enter right of "+root.value);
        boolean right= sc.nextBoolean();
        if(right){
            System.out.println("Enter the right node val : ");
            int value=sc.nextInt();        
            root.right=new Node(value);
            populate(sc, root.right);
        } 
    }

    public void dfsInorder(){
        dfsInorder(this.root, " ");
    }
    public void dfsInorder(Node root, String indent){
        if(root==null){
            return;
        }
        System.out.print(indent+root.value);
        dfsInorder( root.left, indent+"\t");
        dfsInorder( root.right, indent+"\t");
    }
    
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        Scanner sc=new Scanner(System.in);
        bt.pupulate(sc);
        bt.dfsInorder();
    }
}
