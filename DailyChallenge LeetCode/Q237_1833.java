class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        Arrays.sort(costs);
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=costs[i];
            count++;
            if(sum==coins){
                return count;
            }
            if (sum>coins){
                return count-1;
            }
        }
        return count;
    }
}
