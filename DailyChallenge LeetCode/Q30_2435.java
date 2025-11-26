class Solution {
    int m,n;
    int MOD=1_000_000_007;
    Integer[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer[m][n][k];
        return solve(0,0,0,grid,k);
    }
    private int solve(int i,int j,int currSum, int[][] grid,int k){
        if(i>=m || j>=n) return 0;
        int newR=(currSum+grid[i][j])%k;

        if(i==m-1 && j==n-1){
            return newR==0 ? 1 : 0;
        }
        if(dp[i][j][newR]!=null) return dp[i][j][newR];
        int down=solve(i+1,j,newR,grid,k);
        int right=solve(i,j+1,newR,grid,k);
        return dp[i][j][newR]= (int)(down+right)%MOD;

    }
}