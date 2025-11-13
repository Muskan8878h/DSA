class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        int v=adj.size();
        boolean[] visited=new boolean[v];
        ArrayList<Integer> bfs=new ArrayList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
        return bfs;
    }
}