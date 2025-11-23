class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        List<Integer> mod1=new ArrayList<>();
        List<Integer> mod2=new ArrayList<>();
        int sum=0;
        for(int num: nums){
            sum+=num;
            if(num%3==1) mod1.add(num);
            else if(num%3==2) mod2.add(num); 
        }
        if(sum%3==0) return sum;
        int rem=sum%3;
        int opr1=0;
        int opr2=0;
        if(rem==1){
            if(!mod1.isEmpty()) opr1=sum-mod1.get(0);
            if(mod2.size()>=2) opr2=sum-mod2.get(0)-mod2.get(1);
        }
        else{
            if(!mod2.isEmpty()) opr1=sum-mod2.get(0);
            if(mod1.size()>=2) opr2=sum-mod1.get(0)-mod1.get(1);
        }

        return Math.max(opr1,opr2);
    }
}