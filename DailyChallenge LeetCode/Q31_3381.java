class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long[] minpre=new long[k];
        Arrays.fill(minpre,Long.MAX_VALUE/2);
        long prefix=0;
        long ans=Long.MIN_VALUE;
        minpre[0]=0;
        for(int i=0;i<n;i++){
            prefix+=nums[i];
            int r=(i+1)%k;
            ans=Math.max(ans,prefix-minpre[r]);
            minpre[r]=Math.min(minpre[r],prefix);
        }
        return ans;
    }
}