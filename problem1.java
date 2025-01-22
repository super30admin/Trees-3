import java.util.List;
import java.util.ArrayList;

/*
Time Complexity -> O(N)
Space Complexity -> O(N*H)
Since we are creating a copy of array and creating a new array everytime this takes up the additional space bacause the array in java is call by refernce.
*/
class Solution1 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(new ArrayList<>(), targetSum, root, 0);
        return result;
    }

    private void dfs(List<Integer> curr, int targetSum, TreeNode root, int sum) {

        if (root == null) {
            return;
        }

        sum = sum + root.val;
        curr.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(curr);
        }
        dfs(new ArrayList<>(curr), targetSum, root.left, sum);
        dfs(new ArrayList<>(curr), targetSum, root.right, sum);

    }
}

/*
Time COmplecity -> O(N)
Space Complexity -> O(H) 

here using backtracking we are again reusing the same array by removing the last element.
*/

class Solution4 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(new ArrayList<>(), targetSum, root, 0);
        return result;
    }

    private void dfs(List<Integer> curr, int targetSum, TreeNode root, int sum) {

        if (root == null) {
            return;
        }
        sum = sum + root.val;
        curr.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            result.add(new ArrayList<>(curr));
        }
        dfs(curr, targetSum, root.left, sum);
        dfs(curr, targetSum, root.right, sum);
        curr.remove(curr.size() - 1);
    }
}