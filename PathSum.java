package Trees3;
// Time Complexity : O(n^2)
// Space Complexity : O(h) (to store path)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import Trees1.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
public class PathSum {
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList());
        return ans;
    }
    private void helper(TreeNode root, int currSum, int target, List path){
        if(root == null)
            return;
        currSum += root.val;
        path.add(root.val);

        if(root.left==null && root.right == null){
            if(currSum == target){
                ans.add(new ArrayList(path));
            }
        }
        helper(root.left, currSum, target, path);
        helper(root.right, currSum, target, path);
        path.remove(path.size()-1);
    }
}
