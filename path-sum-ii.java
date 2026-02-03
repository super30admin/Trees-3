
// TimeComplexity: O(n) n is number of nodes
// SpaceComplexity: O(h) h is height of the tree
// Explanation:  I traverse the tree using DFS while keeping track of the current root-to-node path and its sum.
// At each node, I add the node value to the running sum and the path list. When I reach a leaf node, I check whether the sum equals the target; if so, I copy the current path into the result list. 
// After exploring both children, I backtrack by removing the last element so the path can be reused for other branches.
class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<>());
        return output;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> list){
        if(root == null) return;

        currSum+=root.val;
        list.add(root.val);

        if(root.left == null && root.right == null) {
            if(currSum == targetSum){
                output.add(new ArrayList<>(list));
            }

        }

        helper(root.left, targetSum, currSum, list);

        helper(root.right, targetSum, currSum, list);
        list.remove(list.size() - 1);

    }
}