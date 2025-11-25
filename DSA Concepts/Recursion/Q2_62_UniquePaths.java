class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo=new int[m][n];
        return countPath(0,0,m,n,memo);
    }
    private int countPath(int row,int col,int m, int n,int[][] memo){
        if(row==m-1 && col==n-1) return 1;
        if(row>=m || col>=n) return 0;
        if(memo[row][col]!=0) return memo[row][col];

        memo[row][col]=countPath(row+1,col,m,n,memo) + countPath(row,col+1,m,n,memo);
        return memo[row][col];
    }
}