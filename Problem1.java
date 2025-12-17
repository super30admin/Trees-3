// Time Complexity : O(V+E) ~ O(N) N is the number of nodes
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Do a DFS from the root while tracking the running sum and current path.
When a leaf node is reached, check if the running sum equals targetSum and store the path.
Backtrack after exploring both children to try other paths.
*/

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        helper(root, 0, targetSum, new ArrayList<>());
        return res;
    }


    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> temp) {
        //base
        if(root == null) {
            return;
        }

        //logic
        currSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                res.add(new ArrayList<>(temp));
            }
        }

        helper(root.left, currSum, targetSum, temp);
        helper(root.right, currSum, targetSum, temp);
        temp.remove(temp.size()-1);
    }
}
