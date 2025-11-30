class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!dfs(graph,i,color,1)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int node, int[] color, int curcol){
        color[node]=curcol;
        for(int nei: graph[node]){
            if(color[nei]==color[node]) return false;
            if(color[nei]==-1){
                if(!dfs(graph,nei,color,1-curcol)) return false;
            }
        }
        return true;
    }
}