//113. Path Sum II

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        result = new ArrayList<>();
        target = targetSum;
        recurse(root, 0, new ArrayList<>());
        
        return result;
    }
    private void recurse(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;
        sum = sum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
        }
        recurse(root.left, sum, path);
        recurse(root.right, sum, path);
        path.remove(path.size() - 1);
    }
}