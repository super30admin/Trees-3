//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_pathSum {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        if(root == null)
            return;

        currSum += root.val;
        List<Integer> li = new ArrayList(path);
        li.add(root.val);
        if(root.left == null && root.right == null && currSum == targetSum){
            result.add(li);
        }
        helper(root.left, targetSum, currSum, li);
        helper(root.right, targetSum, currSum, li);
    }
}
