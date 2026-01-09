/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//core concept is 236
//  same as 1123 
class Solution {
    private static class Pair{
        TreeNode node;
        int d;
        Pair(TreeNode node, int d){
            this.node=node;
            this.d=d;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return depth(root).node;
    }
    private Pair depth(TreeNode root){
        if(root==null) {
            return new Pair(null,0);
        }
        Pair left=depth(root.left);
        Pair right=depth(root.right);
        
        if(left.d > right.d){
            return new Pair(left.node, left.d+1);
        }
        if(right.d > left.d){
            return new Pair(right.node, right.d+1);
        }
        return new Pair(root, left.d+1);
    }
}
