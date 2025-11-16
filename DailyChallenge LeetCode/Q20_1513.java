class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long count = 0;  
        long result = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                result = (result + count) % mod; 
            } else {
                count = 0;
            }
        }

        return (int) result;
    }
}