// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    List<List<Integer>> result; // global as we will change it as we recurse
    List<Integer> path;  // global as we will change it as we recurse
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){ // base case
            return new ArrayList<>(); // return empty
        }
        result = new ArrayList<>(); 
        path = new ArrayList<>();
        dfs(root, 0, targetSum); // passing in the root and required sum
        return result;
    }

    private void dfs(TreeNode root, int currSum, int target){
        if(root == null){ // base case to come out of recursive stack and go up.
            return;
        }
        currSum = currSum + root.val; // incrementing sum
        path.add(root.val); // adding to global variable list
        if(root.left == null && root.right == null && currSum == target){
            result.add( new ArrayList<>(path)); // creating a copy of global variable list and adding to path, copying to avoid overwirte
        }
        dfs(root.left, currSum, target); // traverse left
        dfs(root.right, currSum, target); // traverser right

        path.remove( path.size() - 1); // backtracking, removing last element from path
    }
}