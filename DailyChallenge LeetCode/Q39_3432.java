class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2==0) {
            return n-1;
        }
        return 0;
    }
}