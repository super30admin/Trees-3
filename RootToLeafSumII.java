// Time Complexity : O(n)
// Space Complexity : O(h) recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSumII {
    public class TreeNode {
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

    public List<List <Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    public void pathSumHelper(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if(root == null) {
            return;
        }

        // Adding the root into the list
        list.add(root.val);

        if(root.left == null && root.right == null && root.val == targetSum) {
            // if the node is the leaf node and its value is equal to the required sum, that means we found the path
            // add the list into result
            result.add(new ArrayList<>(list));
        }else{
            // we call on root's right and root's left
            // we propagate the new target to the child nodes as current target-root's value
            pathSumHelper(root.left, targetSum-root.val, list, result);
            pathSumHelper(root.right, targetSum-root.val, list, result);
        }
        // remove the element from list since we the same list is being updated,
        // we want to propagte the path to leaf nodes in the list
        list.remove(list.size()-1);
    }
}
