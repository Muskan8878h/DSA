class Solution {
    public int countCollisions(String directions) {
        int count=0;
        int i=0;
        int n=directions.length();
        int j=n-1;
        
        while(i<n && directions.charAt(i)=='L'){
            i++;
        }
        while(j>=0 && directions.charAt(j)=='R'){
            j--;
        }
        while(i<=j){
            if(directions.charAt(i)=='R' || directions.charAt(i)=='L' ){
                count++;
            }
            i++;
        }
        return count;
    }
}