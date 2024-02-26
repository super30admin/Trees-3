// Time Complexity: O(n)
// Space Complexity: O(n)

public class PathSumII {
    List<List<Integer>> result;
    int target;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.target = targetSum;
        this.path = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;

        //logic
        currSum = currSum + root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == target){
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, currSum);
        helper(root.right, currSum);
        path.remove(path.size() - 1);
    }
}
