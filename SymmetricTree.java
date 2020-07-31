//Time Complexity: O(number of nodes)
//Space Complexity: O(height of tree)
/*Approach
-passing the left subtree and right subtree to the helper function 
-again to continue passing left of left to get compared with right of right
-and right of left to get compared with left of right
-comparing values and if at any point they differ returning false
 */

public class SymmetricTree {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }
       
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
     private boolean isSymmetricHelper(TreeNode left,TreeNode right)
     {
         if(left == null || right == null)
         {
             return left == right;
         }
         if(left.val != right.val)
         {
             return false;
         }
         return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right, right.left);
     }
     public static void main(String args[]) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(4);
        System.out.println(obj.isSymmetric(root));
 
     }

}