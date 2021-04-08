
/*
 * Approach - Recursion
 * have a recursive helper function and check the following conditions
 *  - if both left and right nodes are null, then true
 *  - if either left or right is null and not both, then false
 *  - if the left val and the right val is not equal, then false
 *  - repeat the process recrusively to compare left's left and right's right nodes
 *        and also left's right and right's left node
 */


// Time Complexity - O(N) - N is the number of nodes
// Space Complexity - O(1) no additional space is used

class Solution {
  public boolean isSymmetric(TreeNode root) {

    if(root == null){
      return true;
    }

    return checkIfSymmetric(root.left, root.right);
  }

  public boolean checkIfSymmetric(TreeNode left, TreeNode right){

    if(left == null && right == null){
      return true;
    }

    if(left == null || right == null || left.val != right.val){
      return false;
    }

    return checkIfSymmetric(left.left, right.right) &&
        checkIfSymmetric(left.right, right.left);

  }
}


/*
 * Approach - Iterative
 * have a Stack which keeps record of the nodes being checked if symmetric
 *  - if both left and right nodes are null, then continue
 *  - if either left or right is null and not both, then false
 *  - if the left val and the right val is not equal, then false
 *  - repeat the process iteratively till the stack is empty
 *        to compare left's left and right's right nodes and also
 *        left's right and right's left node and add them to the stack
 */

// Time Complexity - O(N) - N is the number of nodes
// Space Complexity - O(N) size of the Stack

class Solution {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;

    Stack<TreeNode> stack = new Stack<>();
    stack.add(root.left);
    stack.add(root.right);

    while(!stack.isEmpty()){

      TreeNode right = stack.pop();
      TreeNode left = stack.pop();

      if(left == null && right == null){
        continue;
      }

      if(left == null || right == null || left.val != right.val){
        return false;
      }

      stack.add(left.left);
      stack.add(right.right);
      stack.add(left.right);
      stack.add(right.left);
    }

    return true;

  }
}