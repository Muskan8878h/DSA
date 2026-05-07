class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }
        int[] ans = new int[n];
        int start = 0;
        int currentMax = nums[0];
        for (int i = 0; i < n - 1; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            if (currentMax <= suffixMin[i + 1]) {
                int compMax = Integer.MIN_VALUE;
                for (int j = start; j <= i; j++) {
                    compMax = Math.max(compMax, nums[j]);
                }
                for (int j = start; j <= i; j++) {
                    ans[j] = compMax;
                }
                start = i + 1;
                if (start < n) {
                    currentMax = nums[start];
                }
            }
        }
        int compMax = Integer.MIN_VALUE;
        for (int j = start; j < n; j++) {
            compMax = Math.max(compMax, nums[j]);
        }
        for (int j = start; j < n; j++) {
            ans[j] = compMax;
        }
        return ans;
    }
}
