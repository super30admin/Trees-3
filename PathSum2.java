// Time Complexity : O(N)
// Space Complexity : O(h) h is height of tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PathSum2
{
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        helper(root, 0, targetSum);
        return ans;
    }
    public void helper(TreeNode root, int sum, int targetSum)
    {
        if(root == null)
            return;

        path.add(root.val);
        if(sum + root.val == targetSum && root.left == null && root.right == null)
        {
            ans.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }

        helper(root.left, sum+root.val, targetSum);
        helper(root.right, sum+root.val, targetSum);
        path.remove(path.size()-1);
    }
}
