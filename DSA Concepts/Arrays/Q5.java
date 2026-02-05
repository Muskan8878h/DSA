class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int kth;
    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > kth){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
