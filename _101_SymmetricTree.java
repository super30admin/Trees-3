// Time Complexity : o(n) n = number of nodes
// Space Complexity :  o(n) n = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Approach : Recursive approach, pass the two nodes which needs to be compared, node A's left and node B's right should symmetric and also
//node B's left and node A's right should symmetric

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left , TreeNode right) {

        if(left == null && right == null) return true;
        if((left == null && right != null) || (left != null && right == null)) return false;

        return isSymmetric(left.left, right.right) &&
            isSymmetric(left.right, right.left) && (left.val == right.val);
    }

    // Time Complexity : o(n) n = number of nodes
    // Space Complexity :  o(n) n = number of nodes
    // Level order approach : same logic as above
    public boolean isSymmetric(TreeNode root) {

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root.left);
      q.add(root.right);

      while(!q.isEmpty()){

          TreeNode left = q.remove();
          TreeNode right = q.remove();

          if(left == null && right == null) continue;

          if( (left == null && right != null ) || (left != null && right == null) || (left.val != right.val)) return false;

          q.add(left.left);
          q.add(right.right);
          q.add(left.right);
          q.add(right.left);

      }

      return true;


    }
}
