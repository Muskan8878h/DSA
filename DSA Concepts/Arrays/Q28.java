class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int secLargest = -1;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                int num = ch -'0';
                if(num > largest){
                    secLargest = largest;
                    largest = num;
                }
                else if(num > secLargest && num < largest){
                    secLargest = num;
                }
            }
        }
        return secLargest;
    }
}
