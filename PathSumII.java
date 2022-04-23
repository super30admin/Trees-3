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

//Approach 1 where a global variable is created and new Array List if created at each instance hence more time and more space
class Solution {

    // Time Complexity : 0(n^2) where n is the no. of nodes
// Space Complexity : 0(n^2) where n is the no. of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I created a global variable result which store the final path
    //if the current sum matches the target. I also created an ArrayList path to store the path of the tree while finding sum =
    //target. In my recursive call, I add the root to my current sum and the add the root to my path as well to keep a track of the
    //path. Then I check if the current node is the leaf node or not and if the current sum is target sum or not. If yes, then
    //I store the store the path in mu final answer. For my recursion calls, I am passing the root node, current sum upto the
    //current node, target and a new ArrayList path created at every instance.

    List <List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        result = new ArrayList<>();
        helper(root, 0, targetSum, path);
        return result;
    }
    public void helper(TreeNode root, int currentSum, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        currentSum = currentSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == currentSum){
                result.add(path));
                return;
            }
        }
        helper(root.left, currentSum, targetSum, new ArrayList<Integer>(path));
        helper(root.right, currentSum, targetSum, new ArrayList<Integer>(path));
    }
}

//Approach 2 where I save on both time and space by backtracking
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

    // Time Complexity : 0(n)
// Space Complexity : 0 (n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: It's a similar approach as above, but here I used backtracking
    //to delete the last entry if my currentSum did not meet the target and at last I am also deleting entire list. Also, I
    //am not creating a new ArrayList path at every recursive call thus savinf time and space and using a single reference.

    List <List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    public void helper(TreeNode root, int currentSum, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        currentSum = currentSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == currentSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left, currentSum, targetSum, path);
        helper(root.right, currentSum, targetSum, path);
        path.remove(path.size() - 1);
    }
}