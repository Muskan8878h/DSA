class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int water = 0;
        if(n == 1 || n == 0) return 0;

        int[] leftMax = getLM(height, n);
        int[] rightMax = getRM(height, n);
        
        for(int i=0; i<n; i++){
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            water += h;
        }
        return water;
    }
    private int[] getLM(int[] height, int n){
        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        return leftMax;
    }
    private int[] getRM(int[] height, int n){
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        
        for(int i=n-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        return rightMax;
    }
}
