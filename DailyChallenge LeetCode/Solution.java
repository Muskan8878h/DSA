class Solution {
    public int maxOperations(String s) {
        int n=s.length()-1;
        int zeroes=0;
        int ans=0;
        while(n>=0){
            while(s.charAt(n)=='1'){
                n--;
                ans+=zeroes;
                if(n<0) return ans;
            }
            while(s.charAt(n)=='0'){
                n--;
                if(n<0) return ans;
            }
            zeroes++;
        }
        return ans;
    }
}