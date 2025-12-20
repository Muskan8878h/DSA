class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        int duplicate=0;
        for(int count : freq.values()){
            if(count>1) duplicate++;
        }
        int op=0;
        int idx=0;
        while(duplicate>0 && idx < nums.length){
            op++;
            for(int i=0;i<3 && idx<nums.length;i++){
                int val=nums[idx];
                int count=freq.get(val);
                if(count==2){
                    duplicate--;
                }
                freq.put(val,count-1);
                idx++;
            }
        }
        return op;
    }
}©leetcode
