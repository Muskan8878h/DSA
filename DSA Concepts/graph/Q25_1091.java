class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    private static final int[][] dir= {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        boolean[][] vis=new boolean[n][n];
        return bfs(0,0,vis,grid,n);
    }
    private int bfs(int x,int y, boolean[][] vis, int[][] grid,int n){
        vis[x][y]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(x,y,1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int d=curr.dist;
            if(r==n-1 && c==n-1) return d;
            for(int[] dt: dir){
                int nr=r+dt[0];
                int nc=c+dt[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0 && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    q.add(new Pair(nr,nc,d+1));
                }
            }
        }
        return -1;
    }
}