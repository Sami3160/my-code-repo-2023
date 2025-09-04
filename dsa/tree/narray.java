import java.util.*;

public class narray{
    class Node{
        String name;
        ArrayList<Node> children;
        boolean isLocked;
        Node parent;
        int lockedBy;
        public Node(String name){
            this.name=name;
            this.lockedBy=-1;
            this.isLocked=false;
            this.children=new ArrayList<>();
        }
    }
    HashMap<String, Node> map;
    Node root=null;
    public narray(String[] names, int m){
        int n=names.length;

        if(n==0)return;
        map=new HashMap<>();
        root=new Node(names[0]);
        map.put(names[0], root);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i<n) {
            Node parent=q.poll();
            for(int j=0;j<m && i<n;j++){
                Node child=new Node(names[i]);
                child.parent=parent;
                parent.children.add(child);
                q.add(child);
                map.put(names[i], child);
                i++;
            }
        }
    }
    // parent lock check
    public static boolean isLockedParent(Node node){
        Node current=node;
        while(current!=null){
            if(current.isLocked)return true;
            current=current.parent;
        }
        return false;
    }
    public static boolean isLockedChildren(Node node){
        if(node.isLocked)return true;
        for(Node child: node.children){
            isLockedChildren(child);
        }
        return false;
    }
    // child lock check

    public boolean lock(String name, int uid){
        if(!map.containsKey(name)){
            return false;
        }
        Node node=map.get(name);
        if(node.isLocked || node.lockedBy!=uid){
            return false;
        }

        if(isLockedChildren(node) || isLockedParent(node)){
            return false;
        }

        return true;
        
    }


    public boolean unlock(String name, int uid){
        if(!map.containsKey(name)){
            return false;
        }
        Node node=map.get(name);
        if(node.lockedBy!=uid)return false;
        node.isLocked=false;
        node.lockedBy=-1;
        return true;
    }

    public boolean upgrade(String name, int uid){
        Node node=map.get(name);
        if(node.isLocked || !isLockedChildren(node))return false;
        ArrayList<Node> lockedChildren=new ArrayList<>();
        processLockedChildren(lockedChildren, uid, node);
        if(lockedChildren.size()==0)return false;
        for(Node child: lockedChildren){
            if(child.lockedBy!=uid)return false;
        }
        for(Node child : lockedChildren){
            child.lockedBy=-1;
            child.isLocked=false;
        }
        node.lockedBy=uid;
        node.isLocked=true;
        return true;
    }
    public static void processLockedChildren(ArrayList<Node> lockedChildren, int uid, Node node){
        for(Node child : node.children){
            if(child.isLocked)lockedChildren.add(child);
            processLockedChildren(lockedChildren, uid,child);
        }
    }


    public static void printTree(Node root){
        // Node curr=root;
        System.out.println("Root: "+root.name);
        for(Node child: root.children){
            System.out.print(child.name+"-");
        }
        System.out.println();
        for(Node child: root.children){
            printTree(child);
        }
    }


    public static void main(String[] args) {
        narray n1=new narray(new String[]{"india", "china", "itly","europe","brazil","russia","spain","uganda","japan"}, 3);
        printTree(n1.root);
    }

} 