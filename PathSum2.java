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

// TC: o(N);
// SC: o(H) in worst case H can be N. where h is height of the tree
// backtracking solution

//in backtracking after left and righ recursion is completed the element is removed from the path, so no new Array is needed at each node
// if we just do recursion then we need to create new list at evey node
// data strurture in a data structure is always a pointer so its just pointing the reference


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     
        result = new ArrayList<>();
        helper(root,targetSum,0,new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int targetSum,int currSum,List<Integer> path){
        //base
        
        if(root == null) return;
       // action 
        //calculate curr sum 
        currSum += root.val;
        path.add(root.val);
        // check if its last node then only we can check the target
        if(root.left == null && root.right == null){
            //if target = curr and it have no childres then append the path to list
            if(targetSum == currSum){
                // since the path is backtracked and removed we need to add a copy of path to result array
                result.add(new ArrayList<>(path));
            }
        }
        
        //logic
        
        // recurse
        helper(root.left,targetSum,currSum,path);
        helper(root.right,targetSum,currSum,path);
        
        // backtrack
        //removing the last added item in path so that it is backtracked
        path.remove(path.size()-1);
    }
}
