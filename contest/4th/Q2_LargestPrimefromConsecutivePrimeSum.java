class Solution {
    public int largestPrime(int n) {
        int sum=0;
        int max=0;
        for(int i=2;i<=n;i++){
            if(prime(i)){
                sum+=i;
                if(sum>n) break;
                if(prime(sum)){
                    max=sum;
                }
            }
        }
        return max;
    }
    private boolean prime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
©leetcode