class Solution {
    public int findMin(int n) {
        // code here
        int[] coins={10,5,2,1};
        int count=0;
        for(int coin:coins){
            if(n==0) break;
            count+=n/coin;
            n=n%coin;
        }
        return count;
    }
}
