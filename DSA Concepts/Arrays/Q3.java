class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3) return res;
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int n1 = nums[i];
            int target = -(n1);
            twoSum(nums, target, i+1, n-1, n1);
        }
        return res;
    }
    private void twoSum(int[] nums, int target, int i, int j, int n1){
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum > target){
                j--;
            }
            else if(sum < target){
                i++;
            }
            else {
                res.add(Arrays.asList(n1, nums[i], nums[j]));
                i++;
                j--;
                while(i<j && nums[i] == nums[i-1]) i++;
                while(i<j && nums[j] == nums[j+1]) j--;
            }
        }
    }
}
