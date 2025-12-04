class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int[] e: edges) union(e[0],e[1],parent,rank);
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int root=find(i,parent);
            map.put(root,map.getOrDefault(root,0)+1);
        }

        long res=0;
        long remaining=n;
        for(int size: map.values()){
            remaining-=size;
            res+=(long)size*remaining;
        }
        return res;
    }
    private int find(int x,int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);
    }
    private void union(int x,int y,int[] parent, int[] rank){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp==yp) return ;
        if(rank[xp]>rank[yp]){
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