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
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         
        List<Integer> path = new ArrayList<>();
        
        calSum(root, targetSum, 0, path);
        
        return result;
    }
    
    private void calSum(TreeNode root, int target, int curSum, List<Integer> path){
        
        if(root == null){
            return;
        }
        
        path.add(root.val);
        curSum += root.val;
        
        if(root.left == null && root.right == null){
           if(curSum == target){
               List<Integer> temp = new ArrayList<>(path);
               result.add(temp);
           }
           path.remove(path.size()-1);
           return;
        }
        
        calSum(root.left, target, curSum, path);
        calSum(root.right, target, curSum, path);
        
        path.remove(path.size()-1);
    }
}

//Time Complexity :O(n)
// Space Complexity :O(h)