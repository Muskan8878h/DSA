class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: times){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.add(new Pair(k,0));
        res[k]=0;

        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.node;
            int d=top.dist;
            for(Pair nei: adj.get(node)){
                int next=nei.node;
                int wt=nei.dist;
                if(res[node]+wt < res[next]){
                    res[next]=res[node]+wt;
                    pq.add(new Pair(next,res[next]));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,res[i]);
        }        
        return ans== Integer.MAX_VALUE ? -1 : ans;
    }
}