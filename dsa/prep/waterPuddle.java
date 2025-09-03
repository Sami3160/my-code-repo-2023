

import java.util.*;

 class OptimalSet{
        int[] parent;
        int[] rank;
        public OptimalSet(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public int find(int x){
            if(x==parent[x])return x;
            int par=find(parent[x]);
            parent[x]=par;
            return par;
        }

        public boolean union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)return false;
            if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
            }else if(rank[rootX]<rank[rootY]){
                parent[rootY]=rootX;
            }else{
                parent[rootX]=rootY;
                rank[rootY]++;
            }
            return true;
        }
        public boolean isConnected(int x, int y){
            return find(y)==find(x);
        }

        public int getSets(){
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<parent.length;i++){
                set.add(rank[i]);
            }
            return set.size()-1;
        }
    }
public class waterPuddle{
   

    public static void main(String[] args) {
        int m=2, n=3;
        OptimalSet s=new OptimalSet(m*n);
        int[][] events={{0,0}, {1,0}, {0,2}, {1,2}};
        int puddleCount=0;
        int[] res=new int[events.length];
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        boolean[] watered=new boolean[n*m];
        for(int i=0;i<events.length;i++){
            int r=events[i][0];
            int c=events[i][1];
            int id=r*n+c;
            watered[id]=true;
            puddleCount++;
            for (int j = 0; j < dir.length; j++) {
                int newR=r+dir[j][0];
                int newC=c+dir[j][1];
                int newId=newR * n + newC;
                if(newC<0 || newR<0 || newC>=n || newR>=m)continue;
                if(watered[newId]&& s.union(id, newId)){
                    puddleCount--;
                }
            }
            res[i]=puddleCount;
        }
        for (int x : res) {
            System.out.println(x);
        }
        

    }
}