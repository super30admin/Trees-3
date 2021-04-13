/*

Thought Process: Use backtracking approach similar to inorder where we calculate sum and add to a list, if its a leaf node compare the sum with target. If matches copy that list in a new list and add to result. Otherwise do inorder left, inorder right and finally the backtracking condition where u remove the last element each time from the list.

TC -> O(N)
SC -> O(N)

*/

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
class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        //Mistake committed -> Previousl returning null, whereas should return empty list
        if(root == null) return new ArrayList<>();
        backtrack(root, new ArrayList<Integer>(), 0, targetSum);
        return result;
        
    }
    public void backtrack(TreeNode root, List<Integer> list, int currSum, int target){
        if(root == null) return;
        
        currSum += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == target)
                result.add(new ArrayList<>(list));
        }
        backtrack(root.left, list, currSum, target);
        backtrack(root.right, list, currSum, target);
        
        //backtracking
        list.remove(list.size()-1);
    }
}