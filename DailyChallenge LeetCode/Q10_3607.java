import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] parent = new int[c + 1];
        int[] rank = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;
        Function<Integer, Integer> find = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                if (parent[x] != x) parent[x] = this.apply(parent[x]);
                return parent[x];
            }
        };
        BiConsumer<Integer, Integer> union = (a, b) -> {
            int pa = find.apply(a), pb = find.apply(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }
        };
        for (int[] edge : connections) {
            union.accept(edge[0], edge[1]);
        }
        Map<Integer, TreeSet<Integer>> gridOnline = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = find.apply(i);
            gridOnline.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }
        boolean[] offline = new boolean[c + 1];
        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) { 
                if (!offline[x]) {
                    result.add(x);
                } else {
                    int root = find.apply(x);
                    TreeSet<Integer> set = gridOnline.get(root);
                    if (set == null || set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } else { 
                if (!offline[x]) {
                    offline[x] = true;
                    int root = find.apply(x);
                    TreeSet<Integer> set = gridOnline.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
