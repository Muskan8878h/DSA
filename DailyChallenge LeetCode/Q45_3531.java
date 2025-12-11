import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> row = new HashMap<>();
        Map<Integer, int[]> col = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            row.putIfAbsent(x, new int[]{y, y, 0});
            col.putIfAbsent(y, new int[]{x, x, 0});

            int[] r = row.get(x);
            r[0] = Math.min(r[0], y);
            r[1] = Math.max(r[1], y);
            r[2]++;

            int[] c = col.get(y);
            c[0] = Math.min(c[0], x);
            c[1] = Math.max(c[1], x);
            c[2]++;
        }

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            int[] r = row.get(x);
            int[] c = col.get(y);
            if (r[2] < 3 || c[2] < 3) continue;

            boolean left  = y > r[0];
            boolean right = y < r[1];
            boolean above = x > c[0];
            boolean below = x < c[1];

            if (left && right && above && below) {
                count++;
            }
        }

        return count;
    }
}
