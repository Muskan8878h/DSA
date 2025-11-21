class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }

        int count = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] > first[c]) {
                boolean[] seen = new boolean[26];

                for (int i = first[c] + 1; i < last[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                for (int k = 0; k < 26; k++) {
                    if (seen[k]) count++;
                }
            }
        }

        return count;
    }
}