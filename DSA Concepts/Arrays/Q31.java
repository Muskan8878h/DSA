class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int max = 0;
        int add = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            add += nums[i];
        }
        for(int i=0; i<n+1; i++){
            sum += i;
        }
        int res = sum -add; 
        return res;
    }
}
