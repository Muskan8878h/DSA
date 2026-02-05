class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            int step = nums[i] % n;
            int idx = (i + step) % n; //%n for Out of Bound Na jae

            if(idx < 0){
                idx += n;
            }

            res[i] = nums[idx];
        }
        return res;
    }
}
