//Path Sum 2
// Time Complexity O(n)
//Space Complexity no extra space O(1)
// removing the extra node every we are done with a leaf

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
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currNum, List<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.val);
        currNum += root.val;

        if(root.left == null && root.right == null && targetSum == currNum){
           
            result.add(new ArrayList<>(path));

        }

        helper(root.left, targetSum, currNum, path);
       
        
        helper(root.right, targetSum, currNum, path);
         path.remove(path.size()-1);
    }
}
