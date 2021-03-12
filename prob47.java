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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        recur(root, targetSum, 0, op, path);
        return op;
    }
    
    private void recur(TreeNode root, int target, int currSum, List<List<Integer>> op, List<Integer>path){
        
        if(root == null)
            return ;
        currSum = currSum + root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null){
            if(target == currSum){
                List<Integer>temp = new ArrayList<>(path);
                op.add(temp);
            }
            path.remove(path.size()-1);
            return;
        }
        
        recur( root.left, target, currSum, op, path);
        recur(root.right, target, currSum,op, path);
        path.remove(path.size()-1);
        
    }
}