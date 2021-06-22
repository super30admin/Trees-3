// Time Complexity : O(n)), 
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
//Definition for a binary tree node.
package trees3;
import java.util.*;
 class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum {
     List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        target = targetSum;
        helper(root, 0, new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        if(root == null) return;
        currSum += root.val;
        path.add(root.val);
        helper(root.left, currSum, path);
        if(root.left == null && root.right == null){
            if(target == currSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.right, currSum,path);
        path.remove(path.size() - 1);
        
    }   
}
