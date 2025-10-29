class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int maxlen=0;
        int maxcount=0;
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'A']++; //freq of A
            maxcount=Math.max(maxcount,count[s.charAt(i)-'A']);
            int window=i-l+1;
            if(window-maxcount>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxlen=Math.max(maxlen,i-l+1);
        }
        return maxlen;
    }
}