// brute force
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int need = target - numbers[i];
            if(map.containsKey(need)){
                res[0] = map.get(need)+1;
                res[1] = i+1;
            }
            map.put(numbers[i], i);
        }
        return res;
    }
}


// optimal
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        int[] res = new int[2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum > target){
                j--;
            }
            else if(sum < target){
                i++;
            }
            else if(sum == target){
                return new int[]{i+1, j+1};
            }
        }
        return new int[0];
    }
}
