// Bit Manipulation
class Solution {
    public int smallestNumber(int n) {
        int x=1;
        while(x<n){
            x=(x<<1) | 1;
        }
        return x;
    }
}

// Math
class Solution {
    public int smallestNumber(int n) {
        String a=Integer.toBinaryString(n);
        int len=a.length();
        int power=(int)Math.pow(2,len);
        return power-1;
    }
}

// other way
class Solution {
    public int smallestNumber(int n) {
        int res=1;
        while(res<n){
            res=2*res+1;
        }
        return res;
    }
}
    
