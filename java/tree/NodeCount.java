import java.util.*;

class Node{
    int val;
    Node left, right;
    public Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}

public class NodeCount {
    Node root=null;
    
    int index=0;
    public void insertFromString(String str) {
        String[] values = str.split(",");
        index=0;
        root=insert(values);
    }
    Node curr=root;
    public Node insert( String[] values) {
        if(index>=values.length || values[index].equals("null")){
            index++;
            return null;
        }
        Node newNode=new Node(Integer.parseInt(values[index++]));
        newNode.right=insert(values);
        newNode.left=insert(values);
        return newNode;       
    }

    public static void main(String[] args) {
        NodeCount tree = new NodeCount();
        tree.insertFromString("1,2,3,null,null,4,5");
        System.out.println("Node count: " + countPath(tree.root, 7));
    }





    public static int countPath(Node root, int sum){
        ArrayList<Integer> path = new ArrayList<>();
        return countPathHelper(path, sum, root);
    }
    public static int countPathHelper(ArrayList<Integer> path, int sum, Node root){
        int count=0;
        if(root==null){
            return 0;
        }
        path.add(root.val);
        int s=0;
        for(int i = path.size()-1; i >= 0; i--){
            s += path.get(i);
            if(s == sum){
                for(int j = i; j < path.size(); j++){
                    System.out.print(path.get(j) + " ");
                }
                System.out.println();
                count++;
            }
        }
        count+= countPathHelper(path, sum, root.left);
        count+= countPathHelper(path, sum, root.right);
        path.remove(path.size()-1);
        
        return count;
    }
    //new method implementation
    public static int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);

    }
}
