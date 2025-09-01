import java.util.*;


public class jobAllocation {
    public int solution(int[] jobs, int k){
        // int n=jobs.length;
        // if(n<=k){
        //     int max=Integer.MIN_VALUE;
        //     for(int x : jobs)max=Math.max(max, x);
        //     return max;
        // }
        // PriorityQueue<Integer> p1=new PriorityQueue<>();
        // Arrays.sort(jobs);
        // int idx=n-1;
        // int t=k;
        // for(;idx>=0 && t>0;idx--){
        //     p1.offer(jobs[idx]);
        //     t--;
        // }
        // for(int i=n-k-1;i>=0;i--){
        //     int num=p1.poll();
        //     p1.offer(num+jobs[i]);
        // }
        // int max=Integer.MIN_VALUE;
        // while(!p1.isEmpty()){
        //     max=Math.max(max, p1.poll());
        // }
        // return max;




        if (k >= jobs.length) {
        return Arrays.stream(jobs).max().getAsInt();
    }

    // Sort jobs in descending order
    Arrays.sort(jobs);
    int n = jobs.length;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    // Initialize k workers with 0 load
    for (int i = 0; i < k; i++) {
        pq.offer(0);
    }

    // Assign heaviest jobs first
    for (int i = n - 1; i >= 0; i--) {
        int leastLoaded = pq.poll();
        pq.offer(leastLoaded + jobs[i]);
    }

    // Max load will be the max in the heap
    int maxLoad = 0;
    while (!pq.isEmpty()) {
        maxLoad = Math.max(maxLoad, pq.poll());
    }

    return maxLoad;
    }
    public static void main(String[] args) {
        jobAllocation jb=new jobAllocation();
        int [] jobs={5 ,5, 4, 4, 4};
        int k=2;
        System.out.println(jb.solution(jobs,k));
    }
}
