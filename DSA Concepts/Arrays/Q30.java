class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[start] = nums[i];
                start++;
            }
        }
        for(int i=start; i<n; i++){
            nums[i] = 0;
        }
    }
}
