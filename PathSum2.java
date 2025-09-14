//Time Complexity: O(n)
//Space Complexity: O(h)
// Did this code successfully run on Leetcode :Yes
//Approach: Since we have to find all the possible combinations from the root to the leaf, we will use DFS along with backtracking
//We take each and every path, reduce it from the target, if it becomes 0, we add the list to the output, else we backtrack and remove the element from the list
import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

        dfs(root, targetSum, output, new ArrayList<>());

        return output;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> output, List<Integer> combination) {
        if (root == null) return;

        combination.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) output.add(new ArrayList<>(combination));

        dfs(root.left, targetSum - root.val, output, combination);
        dfs(root.right, targetSum - root.val, output, combination);

        combination.removeLast();
    }

    public static void main(String[] args) {
        final PathSum2 pathSum2 = new PathSum2();
        final TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        System.out.println(pathSum2.pathSum(root, 22));
    }
}
