class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: process each value
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;

            // Step 3: check consecutive triples
            for (int i = 0; i + 2 < indices.size(); i++) {
                int left = indices.get(i);
                int right = indices.get(i + 2);

                int dist = 2 * (right - left);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
