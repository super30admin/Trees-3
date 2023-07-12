// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        return helper(root, 0, targetSum, new ArrayList<>(), new ArrayList<>());
    }
    List<List<Integer>> helper(TreeNode node, int sum, int target, List<List<Integer>> ans, List<Integer> list){
        if(node == null) return ans;
        list.add(node.val);
        if(node.left == null && node.right == null && sum + node.val == target){
            ans.add(new ArrayList<>(list));
        }
        helper(node.left, sum + node.val, target, ans, list);
        helper(node.right, sum + node.val, target, ans, list);
        list.remove(list.size() - 1);
        return ans;
    }
}