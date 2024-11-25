// Time Complexity :O(n)
// Space Complexity :0(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class PathSumTwo {
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

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 22,0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        if(root == null) return;

        List<Integer> list = new ArrayList<>(path);
        currSum+=root.val;
        list.add(root.val);

        if(root.left == null && root.right== null){
            if(currSum==targetSum){
                result.add(list);
            }
        }

        helper(root.left, targetSum,currSum,list);
        helper(root.right, targetSum, currSum, list);
    }
}
