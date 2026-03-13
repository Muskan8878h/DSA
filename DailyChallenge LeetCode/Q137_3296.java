class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canReduce(long time, int height, int[] workerTimes) {
        long total = 0;

        for (int t : workerTimes) {
            
            long left = 0, right = (long) Math.sqrt(2.0 * time / t) + 2;
            long best = 0;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long required = t * mid * (mid + 1) / 2;

                if (required <= time) {
                    best = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            total += best;
            if (total >= height) return true;
        }

        return total >= height;
    }
}
