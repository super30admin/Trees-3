// Time Complexity : O(n)
// Space Complexity : O(h)

// Your code here along with comments explaining your approach
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
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        recurPathSum(root, 0, targetSum, output, path);
        return output;
        
    }
    
    private void recurPathSum(TreeNode root, int currSum, int target,List<List<Integer>> output, List<Integer> path){
        //base case
        if(root == null){
            return;
        }
        
        //add root values to currsum and add the node vals to path list
        
        currSum += root.val;
        path.add(root.val);
        
        //leaf nodes
        if(root.left == null && root.right == null){
            if(target == currSum){
                
                //copy path to temp as lists are pass by reference
                List<Integer> temp = new ArrayList<>(path);
                output.add(temp);
            }
            
            path.remove(path.size()  -1);
            return;
        }
        
        recurPathSum(root.left, currSum, target, output, path);
        recurPathSum(root.right, currSum, target, output, path);
        
        //remove node from path so that path can give unique path output instead of traversed ones
        
        path.remove(path.size() -1);
    }
}