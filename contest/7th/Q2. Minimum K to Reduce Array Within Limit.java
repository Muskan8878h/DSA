class Solution {
    public int minimumK(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int x : nums){
            max = Math.max(max, x);
        }
        
        int low=1;
        int high=Math.max(max, (int)Math.sqrt(n)+2);

        while(low <= high){
            int mid = low + (high-low)/2;
            long op = 0;
            for(int x: nums){
                op += (x+mid-1) / mid;
            }
            long limit = (long) mid * mid;
            if(op <= limit){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}©leetcode
