class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        boolean[] isPrime = sieve(maxVal);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            List<Integer> factors = getPrimeFactors(val);
            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return steps;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
                int val = nums[i];
                if (isPrime[val] && !usedPrime.contains(val)) {
                    List<Integer> nextIndices = map.get(val);
                    if (nextIndices != null) {
                        for (int idx : nextIndices) {
                            if (!visited[idx]) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                    usedPrime.add(val);
                }
            }
            steps++;
        }
        return -1;
    }

    // Sieve of Eratosthenes
    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];

        Arrays.fill(prime, true);

        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    // Get unique prime factors
    private List<Integer> getPrimeFactors(int x) {
        List<Integer> factors = new ArrayList<>();

        for (int p = 2; p * p <= x; p++) {
            if (x % p == 0) {
                factors.add(p);

                while (x % p == 0) {
                    x /= p;
                }
            }
        }

        if (x > 1) {
            factors.add(x);
        }

        return factors;
    }
}
