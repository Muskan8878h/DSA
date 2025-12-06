class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        if(m==0) return Arrays.asList(-1);
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist - b.dist);
        pq.add(new Pair(1,0));
        res[1]=0;
        
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.node;
            int d=top.dist;
            
            for(Pair nei: adj.get(node)){
                int next=nei.node;
                int wt=nei.dist;
                
                if(res[node]+wt < res[next]){
                    res[next]=res[node]+wt;
                    parent[next]=node;
                    pq.add(new Pair(next,res[next]));
                }
            }
        }
        // //////////////////////////////
        if (res[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }
        
        List<Integer> path = new ArrayList<>();
        int curr = n;
        while (parent[curr] != curr) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(1);
        
        Collections.reverse(path);

        List<Integer> ans = new ArrayList<>();
        ans.add(res[n]);
        ans.addAll(path);

        return ans;
        
    }
}