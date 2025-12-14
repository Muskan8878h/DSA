class Solution {
    int MOD=1_000_000_007;
    public int numberOfWays(String corridor) {
        int n=corridor.length();
        List<Integer> seats=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S'){
                seats.add(i);
            }
        }
        if(seats.size()==0 || seats.size()%2!=0) return 0;

        long res=1;
        int prevEnd=seats.get(1);
        for(int i=2;i<seats.size();i+=2){
            int currStart = seats.get(i);
            int choice =  currStart - prevEnd;
            res=(res*choice)%MOD;
            prevEnd=seats.get(i+1);
        }
        return (int)res;
    }
}
