// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// o(n)time and o(h) space
class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        dfs(root.left, root.right);
        return isValid;
    }
    private void dfs(TreeNode left, TreeNode right){

        if(left == null && right == null)return;
        if(left == null || right == null || left.val!= right.val){
            isValid = false;
            return;
        }
        dfs(left.left, right.right);
        dfs(left.right, right.left);
    }
}


//o(n) time and //o(h) recursion stack space
class Solution {
    List<List<Integer>> result;
    int target;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        target = targetSum;
        result = new ArrayList<>();
        path = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int curr ){
        if(root == null) return;
        path.add(root.val);
        curr = curr+root.val;
        if(root.left == null && root.right == null){
            if(curr == target){
                result.add( new ArrayList<>(path));
            }
        }
        //logic
        helper(root.left, curr);
        helper(root.right, curr);
        path.remove(path.size()-1);
    }
}