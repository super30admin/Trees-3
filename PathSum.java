// Time Complexity : O(n) + O(n *h) == O(n) , if not all the leaf nodes is giving target sum
// Space Complexity : O(h), where h = number of elements from root to leaf.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();

        if(root == null)
            return result;
        
        //we will add all the nodes in the path into this list. If the path sum == targetSum then we will add list to result
        List<Integer> list = new ArrayList<>();
        helper(root, targetSum, 0, list);

        return result;
    }

    public void helper(TreeNode root, int targetSum, int sum, List<Integer> path) {

        //if there is left subtree but no right subtree
        if(root == null)
            return;

        sum += root.val;
        path.add(root.val);

        //if we reach the leaf node then we check if sum of all nodes from root to leaf is targetSum
        if(root.left == null && root.right == null) {

            if(sum == targetSum) {

                //We create a deep copy of list first and then add the list to result
                //because if we add just result, then it is pass by ref. The result will just store address of list eg:- 420. We will then use the same list for adding other elements. While backtracking we will also pop the elements from the list. So at the end it will be empty at root. Hence result= [[],[]]
                //List<Integer> li = new ArrayList<>(list);
                result.add(new ArrayList<>(path));

            }
        
            //After leaf node is done. we remove it and go to its parent or backtracking
            path.remove(path.size() - 1);
            return;
        }


        helper(root.left, targetSum, sum, path);
        helper(root.right, targetSum, sum, path);
        path.remove(path.size() - 1);
    }
}