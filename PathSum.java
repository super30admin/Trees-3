import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class PathSum {
    List<List<Integer>> out = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return out;
        target = targetSum;
        helper(root, new ArrayList<>(), 0);
        return out;
    }

    private void helper(TreeNode root, List<Integer> list, int sum){
        if(root==null) return;
        list.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null && sum==target)
            out.add(new ArrayList<>(list));
        helper(root.left, list, sum);
        helper(root.right, list, sum);
        list.remove(list.size()-1);
    }
}
