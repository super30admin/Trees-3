/*Time Complexity: O(n) traversing to every node once.
 * Space Complexity: O(h) where h is the height of the tree for storing the temporary path.
 * Leetcode: yes
 * Any Issues: No
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    //this is using backtracking
    private void helper(TreeNode node, int pathSum, int target, List<Integer> path, List<List<Integer>> result)
    {
        if(node == null)
            return;

        pathSum += node.val;
        path.add(node.val);

        if(node.left == null && node.right == null && pathSum == target)
        {
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        helper(node.left, pathSum, target, path, result);
        helper(node.right, pathSum, target, path, result);

        path.remove(path.size()-1);
        
        return;
    }

    //sending a deep copy of the existing path here the space complexity will be more.
    private void helper1(TreeNode node, int pathsum, int target, List<Integer> path, List<List<Integer>> result)
    {
        if(node == null)
            return;
        if(node.left == null && node.right == null && (node.val + pathsum) == target)
        {
            path.add(node.val);
            result.add(path);
            return;
        }
        
        path.add(node.val);
        helper(node.left, pathsum + node.val, target, new ArrayList<>(path), result);
        helper(node.right, pathsum + node.val, target, new ArrayList<>(path), result);

        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        helper(root, 0, targetSum, new ArrayList<>(), result);

        return result;
    }
}