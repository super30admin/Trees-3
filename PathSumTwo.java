//Time Complexity - O(n)
//Space Complexity - O(h)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        //Validate the root
        if (root == null) return new  ArrayList<>();
        return helper(root, 0, targetSum, new ArrayList<>());
    }

    public List<List<Integer>> helper(TreeNode root, int currSum, int targetSum, List<Integer> path)
    {
        //base case
        if (root == null) return new ArrayList<>();

        //logic
        path.add(root.val);
        currSum += root.val;

        if (root.left == null && root.right == null && currSum == targetSum)
        {
            result.add(new ArrayList(path));
        }

        //recurse
        helper(root.left, currSum, targetSum, path);
        helper(root.right, currSum, targetSum, path);

        //back track
        path.remove(path.size() - 1);

        return result;
    }
}