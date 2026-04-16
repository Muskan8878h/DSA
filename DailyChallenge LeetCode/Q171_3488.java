class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            int val = nums[idx];
            List<Integer> list = map.get(val);
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(list, idx);
            int minDist = Integer.MAX_VALUE;
            int prev = list.get((pos - 1 + list.size()) % list.size());
            minDist = Math.min(minDist, circularDist(idx, prev, n));
            int next = list.get((pos + 1) % list.size());
            minDist = Math.min(minDist, circularDist(idx, next, n));
            ans.add(minDist);
        }
        return ans;
    }
    private int circularDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }
}
