class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int sum = 0;
        for(int i=0; i<n; i++){
            Arrays.sort(nums[i]);
        }
        for(int j=m-1; j>=0; j--){
            int maxele = 0;
            for(int i=0; i<n; i++){
                maxele = Math.max(maxele, nums[i][j]);
            }
            sum += maxele;
        }
        return sum;
    }
}
