// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Maintain a global list and add a temp list that satisfies the path sum to the global list
// remove the last item from the temp list if the path sum is not equal to the target
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
             pathSum(root,sum,temp,res);
        return res;
    }
    
    void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
          if (root == null) {
            return;
        }
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer>(path));
        } else {
            pathSum(root.left, sum - root.val, path, res);
            pathSum(root.right, sum - root.val, path, res);
        }
        
        path.remove(path.size() - 1);
    }
}