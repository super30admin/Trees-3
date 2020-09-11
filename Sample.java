// Problem 1 - Path Sum II
// Time Complexity : O(n) where n = all nodes
// Space Complexity : O(maxdepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - check base condition if root equals null
// 2 - subtract val from target
// 3 - add the val to list
// 4 - check if target is 0 and leaf node - add list to output
// 5 - recurrsion on left tree and right tree
// 6 - remove last element from list
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> output = new ArrayList<>();        
    List<Integer> currPath = new ArrayList<>();
    recurr(root, sum, output, currPath);

    return output;

  }

  public void recurr(TreeNode root, int target, List<List<Integer>> output, List<Integer> currPath){
    // 1
    if(root == null) {
      return;
    }
    // 2
    target -= root.val;
    // 3
    currPath.add(root.val);
    
    // 4
    if(root.left == null && root.right == null && target == 0){
      output.add(new ArrayList<>(currPath));
    }
    
    // 5
    recurr(root.left, target, output, currPath);
    recurr(root.right, target, output, currPath);
    
    // 6
    currPath.remove(currPath.size() -1);
  }
}

// Problem 2 - Symmetric Tree
// Time Complexity : O(n) where n = all nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - base condition if root is null
// 2 - recurrsion on leftnode and rightnode
// 3 - keep checking if leftnode and right same
// 4 - recurrsion on left.left, right.right and left.right and right.left
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
      // 1
    if (root == null) {
      return true;
    }
    
      // 2
    return recurr(root.left, root.right);
  }

  private boolean recurr(TreeNode leftNode, TreeNode rightNode) {
    if (leftNode == null && rightNode == null) {
      return true;
    }
      // 3
    if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
      // 4
      return recurr(leftNode.left, rightNode.right) && recurr(leftNode.right, rightNode.left);
    }

    return false;
  }
}
