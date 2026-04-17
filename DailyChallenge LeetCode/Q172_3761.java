class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                int j = map.get(curr);
                minDist = Math.min(minDist, i - j);
            }
            int rev = reverse(curr);
            map.put(rev, i);
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}
