class Solution {
    int maxlen=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxlen;
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        maxlen=Math.max(maxlen,lh+rh);
        return 1+Math.max(lh,rh);
    }
}