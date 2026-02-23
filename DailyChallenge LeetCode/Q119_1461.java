class Solution {
    public boolean hasAllCodes(String s, int k) {
        int needed = 1 << k;  
        boolean[] seen = new boolean[needed];
        int count = 0;
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            num = ((num << 1) & (needed - 1)) | (s.charAt(i) - '0');
            if (i >= k - 1) {
                if (!seen[num]) {
                    seen[num] = true;
                    count++;
                    if (count == needed) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
