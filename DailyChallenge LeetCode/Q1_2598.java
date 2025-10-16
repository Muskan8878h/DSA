class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];
        for (int num : nums) {
            int rem = ((num % value) + value) % value; 
            count[rem]++;
        }
        int mex = 0;
        while (true) {
            int rem = mex % value;
            if (count[rem] == 0) break; 
            count[rem]--;              
            mex++;
        }
        return mex;
    }
}