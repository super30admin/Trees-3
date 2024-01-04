// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, 0, new ArrayList());

        return new ArrayList(result);
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> temp)
    {
        if(root == null) return;

        temp.add(root.val);
        
        helper(root.left, target, sum + root.val, temp);

        helper(root.right, target, sum + root.val, temp);

        if(root.left == null && root.right == null)
        {
            if(sum + root.val == target) result.add(new ArrayList(temp));
        }

        temp.remove(temp.size() - 1);
    }
}