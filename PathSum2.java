//Time Complexity: O(N)
//Space Complexity: O(H)

class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(root, sum, new LinkedList<>(), res);
        return res;
    }
    
    public void backtrack(TreeNode root, int sum, LinkedList<Integer> cur, List<List<Integer>> res) {
        if(root == null)
            return;
        cur.add(root.val);
        if(sum == root.val && root.left == null && root.right == null) {
            res.add(new LinkedList<>(cur));
            cur.removeLast();
            return;
        }
        backtrack(root.left, sum - root.val, cur, res);
        backtrack(root.right, sum - root.val, cur, res);
        cur.removeLast();
    }
}
