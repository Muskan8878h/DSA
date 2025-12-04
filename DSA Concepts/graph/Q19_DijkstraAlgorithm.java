class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0] - b[0]); 
        pq.offer(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int d=top[0];
            int node=top[1];
            if(d>dis[node]) continue;
            for(int [] nei: adj.get(node)){
                int next=nei[0], wei=nei[1];
                if(dis[node]+wei<dis[next]){
                    dis[next]=dis[node]+wei;
                    pq.offer(new int[]{dis[next],next});
                }
            }
        }
        return dis;
    }
}