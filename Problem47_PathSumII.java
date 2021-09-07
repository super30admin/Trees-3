// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<>();
        this.recurseTree(root, targetSum, pathNodes, pathsList);
        return pathsList;
    }
    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        if(node == null)
            return;
        
        pathNodes.add(node.val);
        if(remainingSum == node.val && node.left == null && node.right == null)
            pathsList.add(new ArrayList<>(pathNodes));
        else {
            this.recurseTree(node.left, remainingSum - node.val, pathNodes, pathsList);
            this.recurseTree(node.right, remainingSum - node.val, pathNodes, pathsList);
        }
        pathNodes.remove(pathNodes.size() - 1);
    }
}