class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        ArrayList<Integer> dfsRes=new ArrayList<>();
        boolean[] visited=new boolean[v];
        dfs(0,adj,visited,dfsRes);
        return dfsRes;
    }
    
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsRes){
        visited[node]=true;
        dfsRes.add(node);
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                dfs(neighbour,adj,visited,dfsRes);
            }
        }
    }
}