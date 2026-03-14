class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backtrack(n, "", list);
        if(k > list.size()) return "";
        return list.get(k-1);
    }
    private void backtrack(int n, String curr, List<String> list){
        if(curr.length() == n){
            list.add(curr);
            return ;
        }
        char[] chara = {'a', 'b', 'c'};
        for(char ch : chara){
            if(curr.length() == 0 || curr.charAt(curr.length()-1) != ch){
                backtrack(n, curr + ch, list);
            }
        }
    }
}
