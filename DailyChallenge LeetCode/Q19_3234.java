class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] ones = new int[n + 1];
        int[] zeros = new int[n + 1];

        for (int i = 0; i < n; i++) {
            ones[i + 1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);
            zeros[i + 1] = zeros[i] + (s.charAt(i) == '0' ? 1 : 0);
        }

        // Map: prefixZeroCount -> list of indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.computeIfAbsent(zeros[i], x -> new ArrayList<>()).add(i);
        }

        int maxZ = (int) Math.sqrt(n) + 2;
        long ans = 0;

        for (int z = 0; z <= maxZ; z++) {
            for (int zVal : map.keySet()) {
                int need = zVal + z;

                if (!map.containsKey(need)) continue;

                ArrayList<Integer> A = map.get(zVal);   // starting indices
                ArrayList<Integer> B = map.get(need);   // ending indices

                int p = 0;
                for (int iIdx : A) {

                    int requiredOnes = ones[iIdx] + z * z;

                    while (p < B.size() &&
                           (B.get(p) <= iIdx || ones[B.get(p)] < requiredOnes)) {
                        p++;
                    }

                    if (p < B.size()) {
                        ans += (B.size() - p);
                    }
                }
            }
        }

        return (int) ans;
    }
}
