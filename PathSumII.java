// Time Complexity : O(N) N-> No of Nodes in tree
// Space Complexity : O(H) H-> Height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PathSumII {
    List<List<Integer>> res = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if(root == null)
            return new ArrayList<>();
        calculateSum(root, 0, new ArrayList());
        return res;
    }

    public void calculateSum(TreeNode root, int currSum, List<Integer> list) {

        if(root == null)
            return;
        currSum += root.val;
        list.add(root.val);
        calculateSum(root.left, currSum, list);
        if(root.left == null && root.right == null && currSum == target) {
            res.add(new ArrayList(list));
        }
        calculateSum(root.right, currSum, list);
        list.remove(list.size()-1);
    }
}