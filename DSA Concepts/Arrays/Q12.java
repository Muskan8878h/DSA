class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int minele = Integer.MAX_VALUE;
        int negative = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) {
                    negative ++;
                }
                minele = Math.min(minele, Math.abs(matrix[i][j]) );
            }
        }
        if(negative % 2 == 0){ //even
            return sum;
        }
        return sum - 2*minele; //odd
    }
}
