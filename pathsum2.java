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
    List<List<Integer>> result; //Creates a new global var
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int curSum, List<Integer> path){
        //base
        if (root == null) return;

        curSum += root.val; //Adding the root val to the sum
        path.add(root.val); //ß[*420] //Adding the root val to the path

        if(root.left == null && root.right == null && curSum == targetSum){
            result.add(new ArrayList<>(path)); //Deep copies the path into inanother as a new reference point to the result [*620 - Deep copies to new so that the elem removal doesn't affect the result and only takes change in the *420 of the path]
        }

        left = helper(root.left, targetSum, curSum, path); //Goes to left till leaf node is found

        right = helper(root.right, targetSum, curSum, path); //Then goes to right

        path.remove(path.size() - 1); //Removes the last elem here everytime the leaf node sum doesn't match the target
    }
}