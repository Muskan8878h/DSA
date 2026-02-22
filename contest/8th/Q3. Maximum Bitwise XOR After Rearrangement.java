class Solution {
    public String maximumXor(String s, String t) {
        int n = s.length();
        int one = 0;
        for(char c: t.toCharArray()){
            if(c == '1') one++;
        }
        int zero = n-one;
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++){
            int bit = s.charAt(i) - '0';
            if(bit == 0){
                if(one > 0){
                    ans.append('1');
                    one--;
                }
                else{
                    ans.append('0');
                    zero--;
                }
            }
            else{
                if(zero > 0){
                    ans.append('1');
                    zero--;
                }
                else{
                    ans.append('0');
                    one--;
                }
            }
        }
        return ans.toString();
    }
}©leetcode
