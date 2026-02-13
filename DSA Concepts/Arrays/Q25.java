class Solution {
    public List<Integer> maxPrefixes(List<Integer> arr, List<Integer> leftIndex, List<Integer> rightIndex) {
        // code here.
        List<Integer> res = new ArrayList<>();
        int q = leftIndex.size();
        for(int j=0; j<q; j++){
            int left = leftIndex.get(j);
            int right = rightIndex.get(j);
            
            int sum = 0;
            int max = Integer.MIN_VALUE;
            
            for(int i=left; i<=right; i++){
                sum += arr.get(i);
                max = Math.max(sum, max);
            }
            res.add(max);
        }
        return res;
    }
}
