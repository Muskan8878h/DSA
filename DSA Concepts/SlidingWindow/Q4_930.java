class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res=0;
        int sum=0;
        Map<Integer,Integer> prefixSumCount=new HashMap<>();
        prefixSumCount.put(0,1);
        for(int num:nums){
            sum+=num;
            if(prefixSumCount.containsKey(sum-goal)){
                res+=prefixSumCount.get(sum-goal);
            }
            prefixSumCount.put(sum,prefixSumCount.getOrDefault(sum,0)+1);
        }
        return res;
    }
}