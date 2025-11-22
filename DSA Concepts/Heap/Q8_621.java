class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int f: tasks){
            freq[f-'A']++;
        } 
        int maxfreq=0;
        for(int f: freq){
            maxfreq=Math.max(maxfreq,f);
        }
        int countMax=0;
        for(int f:freq){
            if(f==maxfreq) countMax++;
        }
        int interval=(maxfreq-1)*(n+1)+countMax;
        return Math.max(interval, tasks.length);
    }
}