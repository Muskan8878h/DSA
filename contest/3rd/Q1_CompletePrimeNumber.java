class Solution {
    public boolean completePrime(int num) {
        int temp=num;
        int org=num;
        
        int len=0;
        while(temp>0){
            len++;
            temp/=10;
        }
        
        int m=1;
        for(int i=0;i<len;i++){
            if(!isPrime(num)) return false;
            m*=10;
            
            int suf=org%m;
            int rem=num%10;
            if(!isPrime(suf)){
                return false;
            }  
            num=num/10;
            if(num==0) break;
        }
        return true;
    }
    
    private boolean isPrime(int n){
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
}©leetcode