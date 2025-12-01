class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left=0;
        long right=0;
        
        for(int b: batteries){
            right+=b;
        }
        right/=n;
        long ans=0;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(canRun(mid,n,batteries)){
                ans=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    private boolean canRun(long t, int n, int[] batteries){
        long total=0;
        for(int b: batteries){
            total+=Math.min(b,t);
            if(total>=(long)n*t) return true;
        }
        return total>=(long)n*t;
    }
}