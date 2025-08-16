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
 // This solution creates the arraylist for every path and adds the present number to it. With recursion we go deeper and keep adding elements to the list. At the leaf we add it to the global list. And at each level we backtrack the element so that other path does not get these elements
class Solution {
    List<List<Integer>> lists = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sumItUp(root, 0, targetSum, new ArrayList());
        return lists;
    }

    private void sumItUp(TreeNode root, int runningNumber, int targetSum, List<Integer> runningList) {
        if(root==null) return;
        int sum = runningNumber+root.val;
        runningList.add(root.val);
        if(root.left==null && root.right==null) {
            // If its a leaf node and sum is reached, we add it to the global list
            if(sum==targetSum) lists.add(new ArrayList(runningList));
        }
        // Explore childeren with updated sum and list
        sumItUp(root.left, sum, targetSum, runningList);
        sumItUp(root.right, sum, targetSum, runningList);
        // Backtrack existing element once the children is explored
        runningList.remove(runningList.size()-1);
    }
}
