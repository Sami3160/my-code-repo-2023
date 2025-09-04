import java.util.*;

public class betterNary{
    class Node{
        String name;
        ArrayList<Node> children;
        boolean isLocked;
        Node parent;
        int lockedBy;
        int lockedAnsistor;
        int lockerDecedent;
        public Node(String name){
            this.name=name;
            this.lockedBy=-1;
            this.isLocked=false;
            this.lockedAnsistor=0;
            this.lockerDecedent=0;
            this.children=new ArrayList<>();
        }
    }
    HashMap<String, Node> map;
    Node root=null;
    public betterNary(String[] names, int m){
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

    public static void updateAnsistor(Node node, int deg){
        if(node==null)return;
        node.lockedAnsistor+=deg;
        updateAnsistor(node.parent, deg);
    }
    public static void updateDecendants(Node node, int deg){
        for(Node child: node.children){
            node.lockerDecedent+=deg;
            updateDecendants(child, deg);
        }
    }
    // child lock check

    public boolean lock(String name, int uid){
        if(!map.containsKey(name)){
            return false;
        }
        Node node=map.get(name);
        if(node.isLocked || node.lockedBy!=uid || node.lockedAnsistor!=0 || node.lockerDecedent!=0){
            return false;
        }

        updateAnsistor(node.parent, 1);
        updateDecendants(node, 1);
        node.lockedBy=uid;
        node.isLocked=true;
        // if(isLockedChildren(node) || isLockedParent(node)){
        //     return false;
        // }
        return true;
        
    }

//O(1) to O(h+Dnode)
    public boolean unlock(String name, int uid){
        if(!map.containsKey(name)){
            return false;
        }
        Node node=map.get(name);
        if(node.lockedBy!=uid)return false;
        updateAnsistor(node, -1);
        updateDecendants(node, -1);
        node.isLocked=false;
        node.lockedBy=-1;
        return true;
    }

    public boolean upgrade(String name, int uid){
        Node node=map.get(name);
        // if(node.isLocked || !isLockedChildren(node))return false;
        if(node.isLocked)return false;
        if(node.lockedAnsistor!=0 || node.lockerDecedent==0){
            return false;
        }
        ArrayList<Node> lockedChildren=new ArrayList<>();
        // processLockedChildren(lockedChildren, uid, node);
        // if(lockedChildren.size()==0)return false;
        // for(Node child: lockedChildren){
        //     if(child.lockedBy!=uid)return false;
        // }
        // for(Node child : lockedChildren){
        //     child.lockedBy=-1;
        //     child.isLocked=false;
        // }
        // node.lockedBy=uid;
        // node.isLocked=true;
        Queue<Node> q=new LinkedList<>(node.children);
        q.offer(node);
        while(!q.isEmpty()){
            Node decentant=q.poll();
            if(decentant.isLocked){
                if(decentant.lockedBy!=uid){
                    return false;
                }
                lockedChildren.add(decentant);
            }
            if(decentant.lockerDecedent>0){
                q.addAll(decentant.children);
            }
        }
        for(Node child: lockedChildren){
            unlock(child.name, uid);
        }
          

        
        
        
        return true;
    }
    // public static boolean processLockedChildren(ArrayList<Node> lockedChildren, int uid, Node node){
        // for(Node child : node.children){
        //     if(child.isLocked)lockedChildren.add(child);
        //     processLockedChildren(lockedChildren, uid,child);
        // }
    //    if(node.isLocked){
    //     if(node.lockedBy!=uid){
    //         return false;
    //     }
    //     lockedChildren.add(node);
    //    }
    //    if(node.lockerDecedent==0){
    //     return true;
    //    }

    //    for(Node child : node.children){
    //     processLockedChildren(lockedChildren, uid, child);
    //    }
    //     return true;
    // }


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
        betterNary n1=new betterNary(new String[]{"india", "china", "itly","europe","brazil","russia","spain","uganda","japan"}, 3);
        printTree(n1.root);
    }

} 