class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();

    long smallSum = 0;
    int smallCnt = 0;
    int largeCnt = 0;
    int need;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        need = k - 1;

        long ans = Long.MAX_VALUE;
        int l = 1;

        for (int r = 1; r < n; r++) {
            add(nums[r]);

            while (r - l > dist) {
                remove(nums[l]);
                l++;
            }

            if (smallCnt == need) {
                ans = Math.min(ans, nums[0] + smallSum);
            }
        }
        return ans;
    }

    private void add(int x) {
        if (smallCnt < need) {
            insertSmall(x);
        } else {
            int maxSmall = small.lastKey();
            if (x < maxSmall) {
                removeSmall(maxSmall);
                insertLarge(maxSmall);
                insertSmall(x);
            } else {
                insertLarge(x);
            }
        }
    }

    private void remove(int x) {
        if (small.containsKey(x)) {
            removeSmall(x);
            if (largeCnt > 0) {
                int minLarge = large.firstKey();
                removeLarge(minLarge);
                insertSmall(minLarge);
            }
        } else {
            removeLarge(x);
        }
    }

    private void insertSmall(int x) {
        small.put(x, small.getOrDefault(x, 0) + 1);
        smallSum += x;
        smallCnt++;
    }

    private void removeSmall(int x) {
        int cnt = small.get(x);
        if (cnt == 1) small.remove(x);
        else small.put(x, cnt - 1);
        smallSum -= x;
        smallCnt--;
    }

    private void insertLarge(int x) {
        large.put(x, large.getOrDefault(x, 0) + 1);
        largeCnt++;
    }

    private void removeLarge(int x) {
        int cnt = large.get(x);
        if (cnt == 1) large.remove(x);
        else large.put(x, cnt - 1);
        largeCnt--;
    }
}
