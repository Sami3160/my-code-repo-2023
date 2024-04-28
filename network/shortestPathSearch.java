import java.util.*;
public class shortestPathSearch {
    public static void dijkstra(List<int[]>[] graph, int source) {
        int numNodes = graph.length;
        int[] distance = new int[numNodes];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, source});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDistance = current[0];
            int currentNode = current[1];
            if (currentDistance > distance[currentNode]) {
                continue;
            }
            for (int[] edge : graph[currentNode]) {
                int neighbor = edge[0];
                int weight = edge[1];
                int newDistance = currentDistance + weight;
                if (newDistance < distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    pq.offer(new int[]{newDistance, neighbor});
                }
            }
        }
        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Node " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        List<int[]>[] graph = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new int[]{1, 4});
        graph[0].add(new int[]{2, 1});
        graph[1].add(new int[]{3, 1});
        graph[2].add(new int[]{1, 2});
        graph[2].add(new int[]{3, 5});
        dijkstra(graph, 0);
    }
}