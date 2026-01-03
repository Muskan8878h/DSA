class Solution {
    public int minLength(int[] nums, int k) {
        int sum=0;
        int left=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int val=nums[i];
            map.put(val,map.getOrDefault(val,0)+1);
            if(map.get(val)==1){
                sum+=val;
            }
            while(sum>=k){
                ans=Math.min(ans,i-left+1);
                int leftVal=nums[left];
                map.put(leftVal, map.get(leftVal)-1);
                if(map.get(leftVal)==0){
                    sum-=leftVal;
                }
                left++;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}©leetcode
