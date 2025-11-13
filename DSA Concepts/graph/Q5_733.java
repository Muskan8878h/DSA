class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int org=image[sr][sc];

        if(org==color) return image;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc]=color;

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int[] d: dir){
                int x=curr[0]+d[0];
                int y=curr[1]+d[1];
                if(x>=0 && y>=0 && x<m && y<n && image[x][y]==org){
                    image[x][y]=color;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }
}