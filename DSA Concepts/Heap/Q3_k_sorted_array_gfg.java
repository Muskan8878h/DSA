// User function Template for Java

class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        int[] sorted=Arrays.copyOf(arr,n);
        Arrays.sort(sorted);
        Map<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(arr[i],i);
        }
        for(int i=0;i<n;i++){
            int orgIdx=indexMap.get(sorted[i]);
            if(Math.abs(orgIdx-i)>k){
                return "No";
            }
        }
        return "Yes";
    }
}