class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int num : nums){
            if(num < min){
                min = num;
            }
            max = Math.max(max, num - min);
        }
        if(max == 0) return -1;
        return max;
    }
}
