class Solution {
    int M=1_000_000_007;
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            mp.put(y, mp.getOrDefault(y, 0) + 1);
        }
        long result = 0;  
        long prevHorizontalLines = 0;
        for (int count : mp.values()) {
            long horizontalLines = (long) count * (count - 1) / 2; 
            result = (result + horizontalLines * prevHorizontalLines) % M;
            prevHorizontalLines += horizontalLines;
        }
        return (int) (result % M);
    }
}