// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


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
 // time complexity = O(n*h) -> copying n elements each time(new ArrayList<>(path)), max of h
 // extra spcae = n*h -> n list for max of h elements 
// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         if(root ==null){
//             return new ArrayList<>();
//         }
//         res = new ArrayList<>();
//         dfs(root, 0, new ArrayList<>(), targetSum);
//         return res;
//     }
//     private void dfs(TreeNode root, int currSum, List<Integer> path, int target){
//         if(root == null){
//             return; 
//         }
//         currSum += root.val;
//         path.add(root.val);
//         if(root.left == null && root.right == null){ // leaf node
//             if(currSum == target){
//                 res.add(path);
//             }
//             return;
//         }

//         dfs(root.left, currSum, new ArrayList<>(path), target);
//         dfs(root.right, currSum, new ArrayList<>(path), target);
//     }
// }
// Time and pace optimized

// time : O(n)
//space: O(h)
class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root ==null){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        path = new ArrayList<>();

        dfs(root, 0, targetSum);
        return res;
    }
    private void dfs(TreeNode root, int currSum, int target){
        if(root == null){
            return; 
        }
        currSum += root.val;

        //action
        path.add(root.val);
        if(root.left == null && root.right == null){ // leaf node
            if(currSum == target){
                res.add(new ArrayList<>(path)); // ** make copy of the list 
            }
            //return; // if returns then  path.remove won't be called 
        }

        //recurse
        dfs(root.left, currSum, target);
        dfs(root.right, currSum, target);

        //backtrack
        path.remove(path.size() -  1);
    }
}