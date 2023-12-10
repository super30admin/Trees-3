// Time Complexity : O(N)
// Space Complexity : O(h)
public class Symmertry {
    boolean flag=true;
    public boolean isSymmetric(TreeNode root) {

      helper(root.left, root.right);
      return flag;
    }

    private void helper(TreeNode left, TreeNode right){

      if(left == null && right== null )return;
      if(left == null || right== null){
        flag= false;
        return;
      }
      else if(left.val != right.val){
        flag= false;
      }

      helper(left.left, right.right);
      helper(left.right, right.left);

    }
  }

