class Solution {
    public List<Integer> maxPrefixes(List<Integer> arr, List<Integer> leftIndex, List<Integer> rightIndex) {
        // code here.
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for(int i=leftIndex.get(idx); i<=rightIndex.get(idx); i++){
            sum += arr.get(i);
            max = Math.max(sum, max);
            if(sum < 0){
                sum = 0;
            }
        }
        return res.add(max);
    }
}
