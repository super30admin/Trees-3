/**
Problem : Path sum II
Did it run on leetcode : Yes

Time Complexity : O(n^2), where n is the number of nodes in the tree
Space Complexity : O(n^2), in the worst case, as we make copies of the arrays.

Approach : 
1. Keep traversing the tree, and keep a track of the current sum up until that point.
2. While traversing to the next node in the tree, we pass the copy of the current list of numbers.
3. If the target matches the current sum, then we add the current list to the result list.

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
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;
        if(root == null) {
            return result;
        }
        traverse(root, 0, new ArrayList<>());
        return result;
    }
    private void traverse(TreeNode root, int currSum, List<Integer> temp) {
        if(root == null) return;
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            if(target == currSum) {
                result.add(new ArrayList<>(temp));
            }
        }
        traverse(root.left, currSum, new ArrayList<>(temp));
        traverse(root.right, currSum, new ArrayList<>(temp));
    }
}