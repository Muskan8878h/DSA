class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.add(i);
            }
        }

        int remaining=n;
        while(remaining > 2){
            int size=q.size();
            remaining-=size;

            while(size>0){
                int node=q.poll();
                for(int nei: adj.get(node)){
                    indegree[nei]--;
                    if(indegree[nei]==1){
                        q.offer(nei);
                    }
                }
                size--;
            }
        }
        return new ArrayList<>(q);
    }
}