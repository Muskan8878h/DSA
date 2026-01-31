class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        for(int bit =0; bit <= 30; bit++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums){
                if((num & (1 << bit)) != 0){
                    list.add(num);
                }
            }
            ans = Math.max(ans, listLength(list));
        }
        return ans;
    }
    private int listLength(List<Integer> arr){
        ArrayList<Integer> lis = new ArrayList<>();
        for(int x : arr){
            int idx = Collections.binarySearch(lis, x);
            if(idx < 0) idx = -idx - 1;
            if(idx == lis.size()){
                lis.add(x);
            }
            else{
                lis.set(idx, x);
            }
        }
        return lis.size();
    }
}©leetcode
