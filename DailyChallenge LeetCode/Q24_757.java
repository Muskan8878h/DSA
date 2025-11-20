class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> 
            x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]
        );
        int a = -1, b = -1; 
        int count = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            boolean aIn = a >= start;
            boolean bIn = b >= start;

            if (aIn && bIn) {
                continue;
            } else if (aIn) {
                count++;
                b = a;
                a = end;     
            } else {
                count += 2;
                b = end - 1;
                a = end;
            }
        }

        return count;
    }
}