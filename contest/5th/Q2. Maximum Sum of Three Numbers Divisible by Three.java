class Solution {
    public int maximumSum(int[] nums) {
        List<Integer> one=new ArrayList<>();
        List<Integer> two=new ArrayList<>();
        List<Integer> three=new ArrayList<>();
        for(int num: nums){
            if(num%3==0) one.add(num);
            else if(num%3==1) two.add(num);
            else three.add(num);
        }
        Collections.sort(one,Collections.reverseOrder());
        Collections.sort(two,Collections.reverseOrder());
        Collections.sort(three,Collections.reverseOrder());
        int maxsum=0;
        if(one.size()>=3){
            maxsum=Math.max(maxsum, one.get(0)+one.get(1)+one.get(2));
        }
        if(two.size()>=3){
            maxsum=Math.max(maxsum,two.get(0)+two.get(1)+two.get(2));
        }
        if(three.size()>=3){
            maxsum=Math.max(maxsum, three.get(0)+three.get(1)+three.get(2));
        }
        if(one.size()>=1 && two.size()>=1 && three.size()>=1){
            maxsum=Math.max(maxsum,one.get(0)+two.get(0)+three.get(0));
        }
        return maxsum;
    }
}©leetcode
