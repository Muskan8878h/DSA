class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }

        long[] prefA = new long[n + 1]; 
        long[] prefC = new long[n + 1]; 

        for (int i = 0; i < n; i++) {
            prefA[i + 1] = prefA[i] + (long) strategy[i] * prices[i];
            prefC[i + 1] = prefC[i] + (long) (1 - strategy[i]) * prices[i];
        }

        long ans = originalProfit;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long remove = prefA[mid] - prefA[l];
            long add = prefC[r] - prefC[mid];

            long newProfit = originalProfit - remove + add;
            ans = Math.max(ans, newProfit);
        }

        return ans;
    }
}
