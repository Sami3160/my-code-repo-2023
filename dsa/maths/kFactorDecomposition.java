class kFactorDecomposition {
    int limit;
    int globalMin=Integer.MAX_VALUE;
    int res[];
    int N;
    public int[] minDifference(int n, int k) {
        limit=k;
        res=new int[k];
        
        N=n;
        ArrayList<Integer> divisors=new ArrayList<>();
        for(int i=1;i<=n/2;i++){
            if(n%i==0)divisors.add(i);
        }
        ArrayList<Integer> list=new ArrayList<>();
        // list.add(divisor.get(0));
        // dfs(0, 1, divisors, list);
        // list.remove(0);
        dfs(0,  1, divisors, list);
        return res;
    }

    public void dfs(int index, int product, ArrayList<Integer> divisors, ArrayList<Integer> list){
        if(index==divisors.size() || list.size()>limit)return;
        if(list.size()==limit ){
            int max=list.get(limit-1);
            int min=list.get(0);
            // System.out.println("list formed, "+product+"\t"+N);
            // max=Math.max(Math.max(a,b),c);
            // min=Math.min(Math.min(a,b),c);
                // System.out.println(min+"\t"+max);
            if(product==N && (max-min)<globalMin){
                globalMin=max-min;
                int i=0;
                for(int x : list){
                    res[i++]=x;
                }
            }
            return;
        }
        int value=divisors.get(index);
        if(value*product<=N){
            list.add(value);
            dfs(index, value*product, divisors, list);
            // dfs(index, value*product, divisors, list);
            list.remove(list.size()-1);
        }

        
        // if(n>0){
            // if()
            // list.add(list.get(n-1));


            // list.remove(n-1);
            dfs(index+1, product, divisors, list);
        // }
    }
}