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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int ans=Math.abs(solver(root.right)-solver(root.left));
        if(ans>=2)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int solver(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=1+solver(root.left);
        int right=1+solver(root.right);
        return Math.max(left,right);
    }

}