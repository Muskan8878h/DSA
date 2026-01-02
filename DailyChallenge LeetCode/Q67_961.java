class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        Map<Integer,Integer> freq=new HashMap<>();

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
            if(freq.get(num)==n){
                return num;
            }
        }
        return -1;
    }
}
