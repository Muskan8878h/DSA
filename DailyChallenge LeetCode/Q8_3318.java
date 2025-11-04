class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> elements = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                elements.add(new int[]{e.getKey(), e.getValue()});
            }

            Collections.sort(elements, (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0]; 
                return b[1] - a[1];
            });
            int sum = 0;
            int count = 0;
            for (int[] el : elements) {
                if (count == x) break;
                sum += el[0] * el[1]; 
                count++;
            }
            ans[i] = sum;
        }

        return ans;
    }
}