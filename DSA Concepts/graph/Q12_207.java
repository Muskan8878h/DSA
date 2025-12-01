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