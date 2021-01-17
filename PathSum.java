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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if(root == null) return result;
        target = sum;
        backtrack(root, 0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(TreeNode root, int currSum, List<Integer> path){
        //base case
        if(root == null) return;
        
        //logic
        currSum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }
        
        
        backtrack(root.left, currSum, path);
        backtrack(root.right, currSum, path);
        
        path.remove(path.size()-1);
        
    }
}


/*
backtracking saves space 
action , recursion vs backtracking
study definition differences between the two 
Time complexity: O(N^2) because we are touching all the nodes and making a copy of all the nodes worst case scenario.
BackTracking needs to create a new list when adding to results because of memory reference. 
Most backtracking can be done recursively, but time complexity increases. to O(N). 
*/