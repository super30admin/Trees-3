// Time complexity: O(n)
// Space complexity: O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        helper(root, sum, 0, path, result);
        
        return result;
    }
    
    public void helper(TreeNode root, int target, int currSum, List<Integer> currPath, List<List<Integer>> result){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            if(currSum + root.val == target){         
                
                List<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                result.add(temp);
            }
            
            return;
        }
        
        currPath.add(root.val);
        currSum += root.val;
        
        helper(root.left, target, currSum, currPath, result);
        helper(root.right, target, currSum, currPath, result);
        
        currPath.remove(currPath.size() -1);
    }
}
