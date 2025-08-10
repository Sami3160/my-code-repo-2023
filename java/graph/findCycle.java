import java.util.*;

public class findCycle{
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 0}
        };
        boolean[] visited= new boolean[graph.length];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        ArrayList<ArrayList<Integer>> adj=gridToList(graph);
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCycle(graph.length,adj, i, visited)){
                    System.out.println("Cycle found!");
                }
            }
        }
        System.out.println();
    }
    private static ArrayList<ArrayList<Integer>> gridToList(int[][] grid) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(grid.length);
        for (int i = 0; i < grid.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = i+1; j < grid[0].length; j++) {
                if (grid[i][j] == 1 ) { // Only add edge once for undirected graph
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        return list;
    }
    private static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
        visited[src]=true;
        Queue<int[]> q=new LinkedList<>();
        boolean cycleFound = false;
        q.offer(new int[]{src, -1});
        while(!q.isEmpty()){
            int[] info=q.poll();
            int source=info[0];
            int parent=info[1];
            for(int child: adj.get(source)){
                if(!visited[child]){
                    visited[child]=true;
                    q.offer(new int[]{child, source});
                }else if(parent!=child){
                    System.out.println("Cycle detected between nodes: " + source + " and " + child+" parent: " + parent);
                    // return true;
                    cycleFound = true;
                }
            }
        }
        return cycleFound;
    }
}