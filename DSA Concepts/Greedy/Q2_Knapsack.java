class Solution {
    
    static class Item {
        double val;
        double wt;
        double ratio;

        Item(double val, double wt) {
            this.val = val;
            this.wt = wt;
            this.ratio = val / wt;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        List<Item> items=new ArrayList<>();
        for(int i=0;i<val.length;i++){
            items.add(new Item(val[i],wt[i]));
        }
        Collections.sort(items,(a,b)-> Double.compare(b.ratio, a.ratio));
        
        double totalval=0;
        for(Item it:items){
            if(capacity==0) break;
            if(it.wt<=capacity){
                capacity-=it.wt;
                totalval+=it.val;
            }
            else{
                double fraction=capacity/it.wt;
                totalval+=it.val*fraction;
                capacity=0;
            }
        }
        return Math.round(totalval*1e6)/1e6;
    }
}