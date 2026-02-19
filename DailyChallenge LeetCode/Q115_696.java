class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int count = 1;
        int prev = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                res += Math.min(count, prev);
                prev = count;
                count = 1;
            }
        }
        return res + Math.min(count, prev);
    }
}
