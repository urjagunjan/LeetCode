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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode Current=root;

        while(Current!=null || !stack.isEmpty()){
            if(Current!=null){
                stack.push(Current);
                Current=Current.left;
            }
            else{
                Current=stack.pop();

                k--;
                if(k==0){
                    return Current.val;
                }
                else{
                    Current=Current.right;
                }
            }
        }
        return 0;
        
    }
}