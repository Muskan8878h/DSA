import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;
    long modpow(long a, long e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return r;
    }
    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        long minPrev = complexity[0]; 
        for (int i = 1; i < n; i++) {
            if (minPrev >= complexity[i]) return 0;  
            minPrev = Math.min(minPrev, complexity[i]);
        }

        long fact = 1;
        for (int i = 2; i < n; i++) {
            fact = (fact * i) % MOD;
        }
        return (int) fact;
    }
}
