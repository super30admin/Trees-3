
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> result;
    List<Integer> temp;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
         this.temp = new ArrayList<>();
        helper(root, targetSum, 0);
        return result;
    }

    public void helper(TreeNode root,int targetSum,int currSum){
        if(root == null) return;

        currSum = currSum + root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null &&  currSum == targetSum){
            //add to result
            result.add(new ArrayList<>(temp));
        }

        helper(root.left, targetSum, currSum);
        helper(root.right, targetSum, currSum);
        temp.remove(temp.size()-1);
    }
}
