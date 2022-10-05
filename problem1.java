package Trees-3;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class problem1 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            helper(root, target, 0);
            return result;
        }
        
        public void helper(TreeNode root, int target, int sum){
            if(root == null) return;
            
            al.add(root.val);
            if(sum + root.val == target && root.left == null && root.right == null) {
                result.add(new ArrayList(al));
            }
            helper(root.left, target, sum + root.val);
            helper(root.right, target, sum + root.val);
            al.remove(al.size()-1);
        }
    }
}
