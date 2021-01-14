// Time Complexity : 0(n)
// Space Complexity : 0(h) if counting recurssion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : need to remember to do list.remove(list.size() - 1);

class PathSum {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        list.remove(list.size() - 1);
        return res;
    }
}