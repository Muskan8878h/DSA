class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int left = 0;
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            while(map.size() > k){
                char ch = s.charAt(left);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
                left++;
            }
            if(map.size() == k){
                max = Math.max(max, i-left+1);
            }
        }
        return max;
    }
}
