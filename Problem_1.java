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

// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create the new list and add the path to them
// Your code here along with comments explaining your approach
// class Solution {
//     List<List<Integer>> result;
//     int target;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         result = new ArrayList<>();
//         target = targetSum;
//         //root is null
//         if( root == null ) return result;
//         helper(root, 0, new ArrayList<>());
//         return result;
//     }
//     private void helper( TreeNode root, Integer sum, List<Integer> path){
//         // base
//         if(root == null) return;
//         // logic
//         path.add(root.val);
//         sum = sum + root.val;
//         if( root.left == null && root.right == null){
//             if(sum == target){
//                 result.add(path);
//                 return;
//             }
//         }
//         helper(root.left, sum, new ArrayList<>(path));
//         // st.pop()
//         helper(root.right, sum, new ArrayList<>(path));
//     }
// }

// using backtracking
class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        //root is null
        if( root == null ) return result;
        path = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper( TreeNode root, Integer sum){
        // base
        if(root == null) return;
        // logic
        path.add(root.val);
        sum = sum + root.val;
        if( root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
        }
        // recursion
        helper(root.left, sum);
        // st.pop()
        helper(root.right, sum);
        // backtracking
        path.remove(path.size()-1);
    }
}