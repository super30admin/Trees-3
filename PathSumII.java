// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        result = new ArrayList<>();
        if(root == null){
            return result;
        }

        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int currentSum, int targetSum, List<Integer> list){

        if(root == null){
            return;
        }

        currentSum += root.val;
        list.add(root.val);
        //action

        if(root.left == null && root.right == null && currentSum == targetSum){
            result.add(new ArrayList<>(list));
        }



        helper(root.left, currentSum, targetSum, list);
        helper(root.right, currentSum, targetSum, list);
        //recurse

        list.remove(list.size()-1); // Backtracking

    }
}
