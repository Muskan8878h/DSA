class Solution {
    private int  MOD=1_000_000_007;
    class Pair{
        int node;
        long dist;
        Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r: roads){
            int u=r[0];
            int v=r[1];
            int w=r[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        long[] ways=new long[n];
        ways[0]=1;
        long[] res=new long[n];
        Arrays.fill(res,Long.MAX_VALUE);
        res[0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.node;
            long d=top.dist;

            if (d > res[node]) continue;

            for(Pair nei: adj.get(node)){
                int next=nei.node;
                long wt=nei.dist;
                long nd=d+wt;
                if(nd < res[next]){
                    res[next]=nd;
                    ways[next]=ways[node];
                    pq.add(new Pair(next,nd));
                }
                else if(nd==res[next]){
                    ways[next]=(ways[next] + ways[node]) % MOD;
                }
            }
        }
        return (int)(ways[n-1] % MOD);
    }
}