class Solution {
    public int countValidSelections(int[] nums) {
        int counter=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                int dif = diff(i, nums);
                if(dif==0){
                    counter+=2;
                }
                else if(dif==1){
                    counter+=1;
                }
            }
        }
        return counter;
    }
    public int diff(int index, int[] nums){
        int left=0;
        int right=0;
        for(int i=0; i<index; i++){
            left+=nums[i];
        }
        for(int i=index+1; i<nums.length; ++i){
            right+=nums[i];
        }
        return Math.abs(left-right);
    }
}