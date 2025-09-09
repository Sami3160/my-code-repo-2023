 import java.util.*;
 class DisjointSet{
        int rank[];
        // int height[];
        int parent[];
        public DisjointSet(int n){
            rank=new int[n];
            // height=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int point){
            if(point==parent[point]){
                return point;
            }
            parent[point]=find(parent[point]);
            return parent[point];
        }
        public boolean union(int point1, int point2){
            int parP1=find(point1);
            int parP2=find(point2);
            if(parP1==parP2)return false;
            if(rank[parP1]<rank[parP2]){
                parent[parP1]=parP2;
            }else if(rank[parP1]>rank[parP2]){
                parent[parP2]=parP1;
            }else{
                parent[parP1]=parP2;
                rank[parP2]++;
            }
            return true;
        }
    }
public class rainWaterPuddle{
   
    public static void main(String[] args) {
        int m=3, n=3;
        boolean[] wateredArea=new boolean[m*n];
        int[][] events={{0,0}, {0,1}, {1,2}, {2,1}, {1,1}};
        int[] res=new int[events.length];
        // [(0, 0), (1, 0), (0, 2), (1, 2)];
        int[][] dirs={{0,1}, {0,-1}, {1, 0}, {-1,0}};
        DisjointSet ds=new DisjointSet(n*m);
        int count=0;
        for(int i=0;i<events.length;i++){
            int r=events[i][0];
            int c=events[i][1];
            int point=(r*n) + c;
            wateredArea[point]=true;
            count++;
            for(int[] dir: dirs){
                int newR=r+dir[0];
                int newC=c+dir[1];
                int newId=newR*n + newC;
                if(newC< 0 || newR < 0 || newC >=n || newR>=m)continue;
                if(wateredArea[newId] && ds.union(point, newId)){
                    count--;
                }
            }
            res[i]=count;
        }
        for(int x : res){
            System.out.println(x);
        }
    }

}