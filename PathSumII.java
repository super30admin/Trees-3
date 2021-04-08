/**
 * Approach - Recursion
 * have a recursive helper function
 *  - to accumulate the root val to currentSum
 *  - to add the root val to the path list
 *  - to perform the below checks:
 *        -if the node is leaf (left and right are null)
 *        and also current sum is equal to targetSum
 *        if yes append the path list to the result
 * recursively repeat it to the left and right nodes of root
 */

// Time Complexity - O(N) - N is the number of nodes
// Space Complexity - O(1) no additional space is used
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

    if(root == null){
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    helper(root, targetSum, 0, path, result);

    return result;
  }


  public void helper(TreeNode root, int targetSum, int currentSum, List<Integer> path, List<List<Integer>> result){

    if(root == null){
      return;
    }

    currentSum = currentSum + root.val;
    path.add(root.val);

    if(root.left == null && root.right == null && currentSum == targetSum){
      result.add(new ArrayList<>(path));
    }

    helper(root.left, targetSum, currentSum, path, result);
    helper(root.right, targetSum, currentSum, path, result);

    path.remove(path.size()-1);
  }
}