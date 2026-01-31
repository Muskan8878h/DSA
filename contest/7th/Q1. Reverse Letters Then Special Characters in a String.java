class Solution {
    public String reverseByType(String s) {
        List<Character> letters= new ArrayList<>();
        List<Character> special= new ArrayList<>();
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                letters.add(c);
            }
            else{
                special.add(c);
            }
        }
        Collections.reverse(letters);
        Collections.reverse(special);

        StringBuilder res= new StringBuilder();
        int l=0;
        int sp=0;
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                res.append(letters.get(l++));
            }
            else{
                res.append(special.get(sp++));
            }
        }
        return res.toString();
    }
}©leetcode
