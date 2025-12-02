class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] parent =new int[V];
        int[] rank=new int[V];
        for(int i=0;i<V;i++) {
            parent[i]=i;
        }
        
        for(int u=0;u<V;u++){
            for(int v: adj.get(u)){
                if(u<v){
                    int pu=find(u,parent);
                    int pv=find(v,parent);
                    if(pu==pv) return 1;
                    union(u,v,parent,rank);
                }
            }
        }
        return 0;
        
    }
    private int find(int x,int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
    private void union(int x,int y, int[] parent, int[] rank){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp==yp) return ;
        if(rank[xp] > rank[yp]) {
            parent[yp]=xp;
        }
        else if(rank[xp]<rank[yp]){
            parent[xp]=yp;
        }
        else{
            parent[xp]=yp;
            rank[yp]++;
        }
    }
}