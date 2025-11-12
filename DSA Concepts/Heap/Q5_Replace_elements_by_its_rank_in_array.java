class Solution {
    static int[] replaceWithRank(int arr[], int N) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}
