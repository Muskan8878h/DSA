// // merge sort ----------------------------------
class Solution {
    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        mergeSort(nums, start, end);
        return nums;
    }
    private void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return ;
        }
        int mid = start+(end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }
    private int[] merge(int[] arr, int start, int mid, int end){
        int n = arr.length;
        int[] temp = new int[n];
        int left = start;
        int right = mid+1;
        int idx = 0;
        while(left <= mid && right <= end){
            if(arr[left] < arr[right]){
                temp[idx] = arr[left];
                idx++;
                left++;
            }
            else{
                temp[idx] = arr[right];
                idx++;
                right++;
            }
        }
        while(left <= mid){
            temp[idx] = arr[left];
            left++;
            idx++;
        }
        while(right <= end){
            temp[idx] = arr[right];
            right++;
            idx++;
        }
        idx = 0;
        while(start <= end){
            arr[start] = temp[idx];
            start++;
            idx++;
        }
        return arr;
    }
}



// /// quick sort ----------------------------

class Solution {
    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        quickSort(nums, start, end); 
        return nums;
    }
    private void quickSort(int[] arr, int start, int end){
        if(start >= end) {
            return ;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    private int partition(int[] arr, int start, int end){
        int pos = start;
        for(int i=start; i<end; i++){
            if(arr[i] <= arr[end]){
                int temp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = temp;
                pos++;
            }
        }
        int temp = arr[pos];
        arr[pos] = arr[end];
        arr[end] = temp;
        return pos ;
    }
}


//  selection sort ------------------------

class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

//   bubble sort -------------------------

class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}

//   insertion sort ---------------------

class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
