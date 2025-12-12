class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d= Math.abs ( points[i][0] - points[j][0] ) + Math.abs ( points[i][1] - points[j][1] );
                adj.get(i).add(new Pair(j,d));
                adj.get(j).add(new Pair(i,d));
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,0));

        int sum=0;
        boolean[] vis=new boolean[n];   
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.node;
            int wt=top.dist;

            if(vis[node]==true) continue;
            vis[node]=true;
            sum+=wt;

            for(Pair nei: adj.get(node)){
                int next=nei.node;
                int next_wt=nei.dist;
                if(!vis[next]) {
                    pq.add(new Pair(next,next_wt));
                }
            }
        }
        return sum;
    }
}
