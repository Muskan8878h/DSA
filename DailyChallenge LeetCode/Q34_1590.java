class Solution {
    public int minSubarray(int[] nums, int p) {
        int total=0;
        for(int num: nums){
            total=(total+num)%p;
        }
        int target=total%p;
        if(target==0) return 0;
         
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefix=0;
        int ans=nums.length;

        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int need=(prefix-target+p)%p;
            if(map.containsKey(need)){
                ans=Math.min(ans,i-map.get(need));
            }
            map.put(prefix,i);
        }

        return ans==nums.length ? -1 : ans;
    }
}