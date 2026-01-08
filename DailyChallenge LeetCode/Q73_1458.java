class Solution {
    int m, n;
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return solve(nums1, nums2, 0, 0);
    }

    private int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == m || j == n) {
            return Integer.MIN_VALUE / 2; 
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int val = nums1[i] * nums2[j];
        int takeBoth = val + Math.max(0, solve(nums1, nums2, i + 1, j + 1));
        int skip1 = solve(nums1, nums2, i + 1, j);
        int skip2 = solve(nums1, nums2, i, j + 1);
        return dp[i][j] = Math.max(val, Math.max(takeBoth, Math.max(skip1, skip2)));
    }
}
