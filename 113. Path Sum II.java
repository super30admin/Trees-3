class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        helper(root, targetSum, ans);
        return res;
    }
    public void helper(TreeNode root, int targetSum, List<Integer> ans){
        if(root == null)
            return;
        ans.add(root.val);
        // here, we should pay attenion to:
        // targetSum == root.val, we cannot write targetSum == 0,
        // because till now, we still have one more element which is leaf node
        if(root.left == null && root.right == null && targetSum == root.val)
            res.add(ans);
        // here we must use the new ArrayList<>(ans), rather than directly 
        // using ans, since former one will create a new stack to contain 
        // elements, but the later one will continue add elements in one stack
        helper(root.left, targetSum - root.val, new ArrayList<>(ans));
        helper(root.right, targetSum - root.val, new ArrayList<>(ans));
    }
}