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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        
        target = targetSum;
        
        helper(root, 0,new ArrayList<>());
        
        return result;
        
    }
    
    private void helper(TreeNode root, int csum, List<Integer> path){
        if(root == null) return;
        
        csum += root.val;
        path.add(root.val);
        
        helper(root.right, csum, path);
        if(root.left ==null && root.right == null){
            if(csum == target){
                result.add(new ArrayList<>(path));
            }
        }
            
        helper(root.left, csum, path);
        
        //backtracking
        path.remove(path.size()-1);
        }
    
}

//TC :O(N)
//SC: O(H)
