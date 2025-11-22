// User function Template for Java

class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(int i=0;i<=(n-1)/2;i++){
            int largest=i;
            int left=2*i+1;
            int right=2*i+2;
            if(left<n && arr[left] > arr[largest]){
                return false;
            }
            if(right<n && arr[right] > arr[largest]){
                return false;
            }
        }
        return true;
    }
}