class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long sum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum += grid[i][j];
            }
        }
        if(sum%2 != 0) return false;
        long target = sum/2;

        long gridSum = 0;
        // horizontal
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n; j++){
                gridSum += grid[i][j];
            }
            if(gridSum == target) return true;
        }
        // vertical
        gridSum = 0;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m; j++){
                gridSum += grid[j][i];
            }
            if(gridSum == target) return true;
        }
        return false;
    }
}
