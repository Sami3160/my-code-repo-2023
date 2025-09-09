class Solution {
    int[] parent;
    int[] rank;
    public int find(int node){
        if(node==parent[node]){
            return node;
        }
        parent[node]=find(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2){
        int parentNode1=find(node1);
        int parentNode2=find(node2);
        // int rankNode1=rank[parentNode1];
        // int rankNode2=rank[parentNode2];
        if(parentNode1==parentNode2)return;
        if(rank[parentNode1]<rank[parentNode2]){
            parent[parentNode1]=parentNode2;
        }else if(rank[parentNode2]<rank[parentNode1]){
            parent[parentNode2]=parentNode1;
        }else{
            parent[parentNode1]=parentNode2;
            rank[parentNode2]++;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge: edges){
            union(edge[0],edge[1]);
        }
        // int a=find(source);
        // int b=find(destination);
        // System.out.println(a+"\t"+b );
        return find(source)==find(destination);
    }
}