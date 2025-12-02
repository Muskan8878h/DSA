class Solution {
    int MOD=1_000_000_007;
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] p: points){
            map.put(p[1],map.getOrDefault(p[1],0)+1);
        }
        long sum=0;
        long sumSq=0;
        for(int cnt: map.values()){
            if(cnt>=2){
                long pairs=(long) cnt*(cnt-1)/2;
                pairs%=MOD;
                sum=(sum+pairs)%MOD;
                sumSq=(sumSq+(pairs*pairs)%MOD)%MOD;
            }
        }
        long ans=(sum*sum%MOD-sumSq+MOD)%MOD;
        ans=ans*inv2()%MOD;
        return (int)ans;
    }
    private long inv2(){
        return (MOD+1)/2;
    }
}