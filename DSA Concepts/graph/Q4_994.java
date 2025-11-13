class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int minutes=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted=false;
            for(int k=0;k<size;k++){
                int[] curr=q.poll();
                for(int[] d:dir){
                    int x=curr[0]+d[0];
                    int y=curr[1]+d[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[]{x,y});
                        fresh--;
                        rotted=true;
                    }
                }
            }
            if(rotted) minutes++;
        }
        return fresh==0 ? minutes : -1;
    }
}