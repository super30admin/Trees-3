// Time Complexity: O(n)
// Space Complexity with recursive stack: O(n +maxDepth)
// Space Complexity without recursive stack: O(n)

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(TreeNode node, int target, int curSum, List<Integer> list, List<List<Integer>> res) {
        if(node == null) {
            return;
        }

        list.add(node.val);

        if(node.left == null && node.right == null) {
            if(curSum + node.val == target) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }

        helper(node.left, target, curSum + node.val, new ArrayList<Integer>(list), res);
        helper(node.right, target, curSum + node.val, new ArrayList<Integer>(list), res);

        list.remove(list.size() - 1);

    }
}