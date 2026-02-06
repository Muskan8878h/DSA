class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        for(int r=0; r<nums.length; r++){
            while((long)nums[r] > (long)nums[left] * k){
                left++;
            }
            max = Math.max(max, r-left+1);
        }
        return nums.length-max;
    }
}
