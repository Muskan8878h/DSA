class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        if(connections.length<n-1) return -1;
        for(int[] edge: connections){
            union(edge[0],edge[1],parent,rank);
        }
        int components=0;
        for(int i=0;i<n;i++){
            if(find(i,parent)==i) components++;
        }
        return components-1;
    }
    private int find(int x, int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
    private void union(int x,int y, int[] parent, int[] rank){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp==yp) return;
        if(rank[xp] > rank[yp]){
            parent[yp]=xp;
        }
        else if(rank[xp] < rank[yp]){
            parent[xp]=yp;
        }
        else{
            parent[xp]=yp;
            rank[yp]++;
        }
    }
}