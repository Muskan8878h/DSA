class Solution {

    static final long INF = (long) 1e18;

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {

        int n = source.length();

        // Step 1: Map strings to indices
        Map<String, Integer> mp = new HashMap<>();
        int idx = 0;
        for (String s : original) mp.putIfAbsent(s, idx++);
        for (String s : changed) mp.putIfAbsent(s, idx++);

        int size = idx;

        // Step 2: Group rules by length
        Map<Integer, List<Integer>> lenMap = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            int len = original[i].length();
            lenMap.computeIfAbsent(len, k -> new ArrayList<>()).add(i);
        }

        // Step 3: Build graph
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < size; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < original.length; i++) {
            adj.get(mp.get(original[i]))
               .add(new long[]{mp.get(changed[i]), cost[i]});
        }

        // Step 4: All-pairs shortest path
        long[][] dis = new long[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dis[i], INF);
            dijkstra(i, adj, dis[i]);
        }

        // Step 5: DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            // No operation
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            // Try only valid substring lengths
            for (int len : lenMap.keySet()) {
                if (i + len > n) continue;

                String from = source.substring(i, i + len);
                String to   = target.substring(i, i + len);

                if (!mp.containsKey(from) || !mp.containsKey(to)) continue;

                long c = dis[mp.get(from)][mp.get(to)];
                if (c < INF && dp[i + len] < INF) {
                    dp[i] = Math.min(dp[i], c + dp[i + len]);
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }

    // Dijkstra
    private void dijkstra(int src, List<List<long[]>> adj, long[] dist) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[src] = 0;
        pq.add(new long[]{0, src});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) continue;

            for (long[] e : adj.get(u)) {
                int v = (int) e[0];
                long w = e[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.add(new long[]{dist[v], v});
                }
            }
        }
    }
}
