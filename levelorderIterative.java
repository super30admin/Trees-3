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
    Queue<TreeNode>q = new LinkedList<>();
     List<Integer> li =new ArrayList<>();
    List<List<Integer>>result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root);
        return result;
    }
    private void helper(TreeNode root){
        //base
        if(root == null) return;
        //logic
        
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
           
            TreeNode cur = q.poll();
           
            if(cur==null)
            {
                result.add(new ArrayList<>(li));
                 
                li.clear();
                if(q.isEmpty()) return;
                q.add(null);
                continue;
            }
            li.add(cur.val);
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
            
        }
        return;
        
    }
}