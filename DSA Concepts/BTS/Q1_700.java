class Solution {
    public TreeNode searchBST(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            return root;
        }
        else if(root.val>key){
            return searchBST(root.left,key);
        }
        else {
            return searchBST(root.right,key);
        }
    }
}