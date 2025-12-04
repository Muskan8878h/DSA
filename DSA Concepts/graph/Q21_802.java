class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean[] vis=new boolean[n];
        int[] path=new int[n];
        int[] check=new int[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,path,check,graph);
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int node, boolean[] vis, int[] path, int[] check, int[][] graph){
        vis[node]=true;
        path[node]=1;
        check[node]=0;
        for(int nei: graph[node]){
            if(!vis[nei]){
                if(dfs(nei,vis,path,check,graph)) return true;
            }
            else if(path[nei]==1){
                return true;
            }
        }
        path[node]=0;
        check[node]=1;
        return false;
    }
}