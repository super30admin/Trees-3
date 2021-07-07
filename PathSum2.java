// Time Complexity : O(n)
// Space Complexity : with recursive stack : O(maxDepth) without recursive stack : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    // Brute Force
    // Creating new ArrayList for every path, so no backtracking
    public List<List<Integer>> pathSumNewList(TreeNode root, int sum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        recurrNewList(root, 0, sum, currPath, output);
        return output;
    }

    private void recurrNewList(TreeNode root, int currSum, int target, List<Integer> currPath, List<List<Integer>> output){
        // base
        if(root == null){
            return;
        }

        // If sum = target, add in total path in output
        if(root.left == null && root.right == null){
            if(currSum + root.val == target){
                currPath.add(root.val);
                output.add(currPath);
            }
            return;
        }

        // logic

        currPath.add(root.val);
        currSum += root.val;

        recurrNewList(root.left, currSum, target, new ArrayList<>(currPath), output);
        recurrNewList(root.right, currSum, target, new ArrayList<>(currPath), output);
    }

    // Optimized for space complexity

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        recurr(root, 0, sum, currPath, output);
        return output;
    }

    private void recurr(TreeNode root, int currSum, int target, List<Integer> currPath, List<List<Integer>> output){
        // base
        if(root == null){
            return;
        }

        // If sum = target, add in total path in output
        if(root.left == null && root.right == null){
            if(currSum + root.val == target){
                List<Integer> temp = new ArrayList<>(currPath);
                temp.add(root.val);
                output.add(temp);
            }
            return;
        }

        // logic

        currPath.add(root.val);
        currSum += root.val;

        recurr(root.left, currSum, target, currPath, output);
        recurr(root.right, currSum, target, currPath, output);
        currPath.remove(currPath.size() - 1);

    }
}
