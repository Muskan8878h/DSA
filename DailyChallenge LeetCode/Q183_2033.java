class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }
        int rem = list.get(0) % x;
        for (int num : list) {
            if (num % x != rem) return -1;
        }
        Collections.sort(list);
        int median = list.get(list.size() / 2);
        int ops = 0;
        for (int num : list) {
            ops += Math.abs(num - median) / x;
        }
        return ops;
    }
}
