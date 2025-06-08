import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 113. Path Sum II
 * Link: https://leetcode.com/problems/path-sum-ii/description/
 */
// ------------------------------------ Solution 1 ------------------------------
public class PathSumTwo {
    /**
     * Using preorder traversal logic process each node along the way to leaf and keep on adding them
     * in a list which is a parameter in our recursive function. Same way maintain a running sum from root to leaf
     * passed as parameter to our recursive function. As integer is passed by value, we do not need to worry about
     * resetting its value as it traverses from left to root to right etc as we will get that value from recursive stack when it
     * unfolds with its original value when it was added to the recursive stack. Same is not true for a list as it
     * passes by reference inside the recursive stack> Hence do a deep copy at each node to tackle this issue
     * At the leaf is running sum is same as target add the current path to the result
     *
     * TC: O(nh) h-> heigh of the tree, worst case n Auxiliary SC: O(nh) new list at each node with h length,worst case h=n
     * Recursive stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, path, targetSum, 0);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> path, int targetSum, int sum) {
        //base
        if (root == null) {
            return;
        }

        //logic
        sum += root.val;
        List<Integer> newPath = new ArrayList<>(path); // TC O(h)
        newPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(newPath);
            }
        }

        traverse(root.left, newPath, targetSum, sum);
        traverse(root.right, newPath, targetSum, sum);
    }
}

// ------------------------------------ Solution 2 ------------------------------
class PathSumTwo2 {
    /**
     * Space and time complexity in above problem can be approved by eliminating the need to do the deep copy
     * at each node by using a single list with backtracking which is once the path on your left and right subtree is fully explored
     * remove the current node's value from the path
     *
     * TC: O(n) Auxiliary SC: O(h) due to path list h -> height of tree, worst case O(n), complete BST O(log n)
     * Recursive stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(root, path, targetSum, 0);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> path, int targetSum, int sum) {
        //base
        if (root == null) {
            return;
        }

        //logic
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path)); // consider this TC O(1) as a handful of results should be present
            }
        }

        traverse(root.left, path, targetSum, sum);
        traverse(root.right, path, targetSum, sum);
        path.remove(path.size() - 1);
    }

}
