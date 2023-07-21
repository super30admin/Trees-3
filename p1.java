// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    //Declaring result in global scope
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //Initialize result
        result = new ArrayList<>();
        //Using arraylist to store the path and integer to store the currentsum
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list, targetSum );
        return result;
    }

    public void helper(TreeNode root,int csum, List<Integer> list, int targetSum ){
        //base condition
        //Add the current value to sum and if that matches the target then create a new list and put elements of the list into it. Add new list to result
        if(root == null) return;
        csum = csum + root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(csum == targetSum){
                List<Integer> res = new ArrayList<>(list);
                result.add(res);
                
            }
            
        }

        //left side recursion
        helper(root.left, csum, list, targetSum );

        //right side recursion
        helper(root.right, csum, list, targetSum );

        //backtracking the element as list is passed by reference
        list.remove(list.size() - 1);

    }
}