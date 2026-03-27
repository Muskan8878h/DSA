class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int shift = k % m;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i%2 == 0){
                    if(mat[i][j] != mat[i][(j + shift) % m]) return false;
                }
                else{
                    if(mat[i][j] != mat[i][(j - shift + m) % m]) return false;
                }
            }
        }
        return true;
    }
}
