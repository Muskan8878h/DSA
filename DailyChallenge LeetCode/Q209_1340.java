class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = arr[i];
            vec[i][1] = i;
        }
        Arrays.sort(vec, (a, b) -> a[0] - b[0]);

        for (int[] it : vec) {
            int i = it[1];

            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }

            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }
        }

        return Arrays.stream(t).max().getAsInt();
    }
}
