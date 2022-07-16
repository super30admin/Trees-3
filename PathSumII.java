//Time Complexity = O(N)
//Space Complexity = O(H)
//Microsoft Interview.
//Given A binary tree and calculating the sum of every leaf node staarting from tree and storing in same memory location.The target variable = 22 and after dealing with root to the leaf nodes out of which 2 are equal to the target to the sum [5,4,11,2][5,8,4,5].Checks from the root to the child leaf node.The root.left till the next child it will be null then it checks right node of the tree and removes the current leaf node from the list.

//Backtacking :we reach the destination if that was the not the answe then we go for other directior, it is nothing but the optimize approach of recursion.
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
//Global variable assigned here
    List<List<Integer>> result;

    int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();

        target = sum;

        if(root == null) return result;

        helper(root, 0, new ArrayList<>());

        return result;

    }

    private void helper(TreeNode root, int currSum, List<Integer> path){

        // Base 

        if(root == null) return;

        currSum += root.val;

        path.add(root.val);

        if(root.left == null && root.right == null){

            if(target == currSum){
 //Create a new arraylist and target over the list and copy over the path.
                result.add(new ArrayList<>(path));

            }

        }

        // logic

        helper(root.left, currSum, path);

        helper(root.right, currSum, path);

        // backtrack

        path.remove(path.size() - 1);
    }
}