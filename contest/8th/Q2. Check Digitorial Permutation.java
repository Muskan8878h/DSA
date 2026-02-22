class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i=1; i<10; i++){
            fact[i] = fact[i-1] * i;
        }
        int[] freqDig = new int[10];
        int temp = n;
        while(temp>0){
            freqDig[temp % 10]++;
            temp /= 10;
        }
        int sum = 0;
        temp = n;
        while(temp>0){
            sum += fact[temp% 10];
            temp /= 10;
        }
        int[] freqSum = new int[10];
        temp = sum;
        while(temp>0){
            freqSum[temp % 10]++;
            temp /=10;
        }
        for(int i=0; i<10; i++){
            if(freqDig[i] != freqSum[i]){
                return false;
            }
        }
        return true;
    }
}©leetcode
