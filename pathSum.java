// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            helper(root, targetSum, 0, new ArrayList());
            return result;
        }
        
        private void helper(TreeNode root, int targetSum, int currSum, List<Integer> currList) {
            if (root == null) {
                return;
            }
            
            if (root.left == null && root.right == null && currSum + root.val == targetSum) {
                currList.add(root.val);
                result.add(new ArrayList(currList));
                currList.remove(currList.size() - 1);
                
                return;
            }
            currSum += root.val;
            currList.add(root.val);
            
            helper(root.left, targetSum, currSum, currList);
            helper(root.right, targetSum, currSum, currList);
            
            //nullify 
            currList.remove(currList.size() - 1);
        }
    } 
}
