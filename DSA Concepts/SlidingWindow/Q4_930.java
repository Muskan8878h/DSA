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

// optimal 

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            res+=map.getOrDefault(sum-goal,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}