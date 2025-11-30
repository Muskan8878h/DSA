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


// bfs
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!bfs(graph,i,color,1)) return false;
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph, int start, int[] color, int curcol){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);  
        color[start]=curcol;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int nei: graph[node]){
                if(color[nei]==-1){
                    color[nei]=1-color[node];
                    q.offer(nei);
                }
                else if(color[nei]==color[node]) return false;
            }
        }
        return true;
    }
} 