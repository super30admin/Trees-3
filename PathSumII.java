
//https://leetcode.com/problems/path-sum-ii/
/*
Time: O(n)
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList();
        findPaths(root, sum, new ArrayList<Integer>(), result);
        return result;

    }

    void findPaths(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {

        if (root == null)
            return;

        current.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(current);
            return;
        }

        findPaths(root.left, sum - root.val, new ArrayList<Integer>(current), result);
        findPaths(root.right, sum - root.val, new ArrayList<Integer>(current), result);

    }

}
