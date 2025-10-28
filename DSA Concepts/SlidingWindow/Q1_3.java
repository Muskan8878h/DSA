import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxlen=0;
        Map<Character,Integer> map=new HashMap<>();
        while(r<s.length()){
            char c=s.charAt(r);
            if(map.containsKey(c) && map.get(c)>=l ){
                l=map.get(c)+1;
            }
            map.put(c,r);
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }   
}