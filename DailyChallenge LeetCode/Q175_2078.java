class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 1;
        for(int i=0; i<n; i++){
            if(colors[i] != colors[n-1]){
                res = Math.max(res, n-i-1);
                break;
            }
        }
        for(int j=n-1;j>=0;j--){
            if(colors[j] != colors[0]){
                res = Math.max(res, j);
                break;
            }
        }
        return res;
    }
}
