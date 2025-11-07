class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; ++i) pref[i + 1] = pref[i] + stations[i];
        long[] power = new long[n];
        for (int i = 0; i < n; ++i) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = pref[R + 1] - pref[L];
        }
        long left = 0;
        long right = pref[n] + k;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1]; 
        long currAdd = 0;
        long used = 0;

        int windowLen = 2 * r + 1;
        for (int i = 0; i < n; ++i) {
            currAdd += diff[i]; 
            long have = power[i] + currAdd;
            if (have < target) {
                long need = target - have;
                used += need;
                if (used > k) return false; 

                currAdd += need;
                int end = i + windowLen; 
                if (end <= n - 1) {
                    diff[end] -= need;
                } else {
                    diff[n] -= need;
                }
            }
        }
        return true;
    }
}
