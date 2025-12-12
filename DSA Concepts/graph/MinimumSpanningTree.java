class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.add(new Pair(0,0));
        
        boolean[] vis=new boolean[V];
        
        int sum=0;
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.node;
            int wt=top.dist;
            
            if(vis[node]==true) continue;
            
            vis[node]=true;
            sum+=wt;
            
            for(Pair nei: adj.get(node)){
                int next=nei.node;
                int nei_wt=nei.dist;
                
                if(!vis[next]) {
                    pq.add(new Pair(next,nei_wt));
                }
            }
        }
        return sum;
        
    }
}
