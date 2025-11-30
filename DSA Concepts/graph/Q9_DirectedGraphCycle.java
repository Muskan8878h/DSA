class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] vis=new boolean[V];
        boolean[] rec=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,vis,rec,adj)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,boolean[] vis, boolean[] rec, List<List<Integer>> adj){
        vis[node]=true;
        rec[node]=true;
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                if(dfs(nei,vis,rec,adj)) return true;
            }
            else if(rec[nei]){
                return true;
            }
        }
        rec[node]=false;
        return false;
    }
}