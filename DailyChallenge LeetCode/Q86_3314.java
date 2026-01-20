class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){

            boolean found=false;
            int val=nums.get(i);

            for(int x=0;x<val;x++){
                if( (x | (x+1)) == val){
                    res[i]=x;
                    found=true;
                    break;
                }
            }
            if(!found){
                res[i]=-1;
            }
        }
        return res;
    }
}
