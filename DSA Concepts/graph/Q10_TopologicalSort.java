class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
        }
        
        boolean[] vis=new boolean[V];
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,s);
            }
        }
        
        ArrayList<Integer> topo=new ArrayList<>();
        while(!s.isEmpty()){
            topo.add(s.pop());
        }
        return topo;
        
    }
    private void dfs(int node,List<List<Integer>> adj, boolean[] vis, Stack<Integer> s){
        vis[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]){
                dfs(nei,adj,vis,s);
            }
        }
        s.push(node);
    }
}