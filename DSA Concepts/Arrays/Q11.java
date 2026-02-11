class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[r][c];

        if(n*m != r*c) return mat;

        int row = 0;
        int col = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[row][col]=mat[i][j];
                col++;
                if(col == c){
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }
}
