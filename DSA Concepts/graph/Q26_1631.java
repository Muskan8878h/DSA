class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        int[][] res=new int[m][n];
        for(int[] r: res) Arrays.fill(r,Integer.MAX_VALUE);

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.add(new Pair(0,0,0));
        res[0][0]=0;

        while(!pq.isEmpty()){
            Pair top=pq.poll();

            int r=top.row;
            int c=top.col;
            int eff=top.dist;

            if (r==m-1 && c==n-1) return eff;

            for(int[] d: dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int diff=Math.abs(heights[r][c]-heights[nr][nc]);
                    int newEff=Math.max(eff,diff);

                    if(newEff < res[nr][nc]){
                        res[nr][nc]=newEff;
                        pq.add(new Pair(nr,nc,newEff));
                    }
                }
            }
        } 
        return 0;
    }
}