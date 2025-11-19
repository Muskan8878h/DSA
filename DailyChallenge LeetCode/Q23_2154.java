class Solution {
    public int findFinalValue(int[] nums, int original) {
        for(int i=0;i<nums.length;i++){
            boolean found=false;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==original){
                    original*=2;
                    found=true;
                    break;
                }
            }
            if(!found) break;
        }
        return original;
    }
}