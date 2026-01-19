class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existsSquare(prefix, mid, threshold, m, n)) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
    private boolean existsSquare(int[][] prefix, int k, int threshold, int m, int n) {
        for (int i = k; i <= m; i++) {
            for (int j = k; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - k][j]
                        - prefix[i][j - k]
                        + prefix[i - k][j - k];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
