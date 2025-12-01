class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] p: prerequisites){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        return count==numCourses;
    }
}


// dfs 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p: prerequisites){
            adj.get(p[1]).add(p[0]);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] rec=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,vis,rec,adj)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, boolean[] vis, boolean[] rec,List<List<Integer>> adj){
        vis[node]=true;
        rec[node]=true;
        for(int nei: adj.get(node)){
            if(!vis[nei]){
                if(dfs(nei,vis,rec,adj)) return true;
            }
            else if(rec[nei]){
                return true;
            }
        }
        rec[node]=false;
        return false;
    }
}