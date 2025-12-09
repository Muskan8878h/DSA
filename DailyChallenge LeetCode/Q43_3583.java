class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;
        Map<Integer, Long> right = new HashMap<>();
        Map<Integer, Long> left = new HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int mid = nums[j];
            right.put(mid, right.get(mid) - 1);

            long target = mid * 2L;

            long leftCount = left.getOrDefault((int)target, 0L);
            long rightCount = right.getOrDefault((int)target, 0L);

            ans = (ans + (leftCount * rightCount) % mod) % mod;
            left.put(mid, left.getOrDefault(mid, 0L) + 1);
        }

        return (int) ans;
    }
}
