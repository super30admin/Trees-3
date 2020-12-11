/** Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
* TC O(N) and SC is O(N*N) worst case but if there are fewer paths with sum equal to given sum it significantly
*improves performance
* Code submitted on leetcode
*/
class Solution {
    List<List<Integer>> sumList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
     if (root == null)
          return sumList;
        helper(root, 0, sum, new ArrayList<Integer>());
        return sumList;
    }
    
    private void helper(TreeNode root, int result, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        result = result + root.val;
        if (root.left == null && root.right == null) {
           if (result == sum){
               sumList.add(new ArrayList<Integer>(path));
           }
        }
        helper(root.left, result, sum, path); 
        helper(root.right, result, sum, path); 
        path.remove(path.size() - 1);
    }
}
