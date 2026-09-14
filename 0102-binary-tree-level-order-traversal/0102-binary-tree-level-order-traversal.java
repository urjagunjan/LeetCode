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
    class level{
        int lvl;
        TreeNode node;
        public level(int lvl,TreeNode node){
            this.lvl=lvl;
            this.node=node;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<level> q=new LinkedList<>();
        q.add(new level(0,root));
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        if(root==null)return res;
        while(!q.isEmpty()){
            level temp=q.poll();
            int lvl=temp.lvl;
            TreeNode node=temp.node;
            map.computeIfAbsent(lvl,k-> new ArrayList<>()).add(node.val);
            if(node.left!=null)
            q.offer(new level(lvl+1,node.left));
            if(node.right!=null)
            q.offer(new level(lvl+1,node.right));
        }

        for(List<Integer> temp:map.values()){
            res.add(temp);
        }
        return res;
    }
}