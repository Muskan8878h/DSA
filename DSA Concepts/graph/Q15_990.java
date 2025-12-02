class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(String e: equations){
            if(e.charAt(1)=='='){
                int a=e.charAt(0)-'a';
                int b=e.charAt(3)-'a';
                union(a,b,parent,rank);
            }
        }
        for(String e: equations){
            if(e.charAt(1)=='!'){
                int a=e.charAt(0)-'a';
                int b=e.charAt(3)-'a';
                if(find(a,parent)==find(b,parent)){
                    return false;
                }
            }
        }
        return true;

    }
    private int find(int x, int[] parent){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x],parent);
    }
    private void union(int x,int y, int[]parent, int[] rank){
        int xp=find(x,parent);
        int yp=find(y,parent);
        if(xp==yp) return;
        if(parent[xp] > parent[yp]){
            parent[yp]=xp;
        }
        else if(parent[xp] < parent[yp]){
            parent[xp]=yp;
        }
        else{
            parent[xp]=yp;
            rank[yp]++;
        }
    }
}