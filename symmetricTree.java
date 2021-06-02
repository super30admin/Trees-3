package Tree1;

/*S30 Big N Problem #48 {Easy} - https://www.youtube.com/watch?v=1d8TeuM2nPQ

You are given a binary tree and you have to check whether its a mirror of itself or we can say symmetric around its center. 
Try solving it recursively and iteratively

For example, this binary tree [11,2,2,33,5,5,33] is symmetric:

   11
   / \
  2   2
 / \ / \
33  5 5  33

But the following [111,2,2,null,333,null,3] is not:

   111
   / \
  2   2
   \   \
   333    3
 -------------------------------------------------------------------------------------------------------
Source Link: https://leetcode.com/problems/symmetric-tree/
    Time complexity : o(n)
    space complexity: o(1) 
    Did this code run successfully in leetcode : yes
    problems faces : no*/
    
public class symmetricTree {
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;
        
        helper(root.left,root.right);
        
        return isValid;

    }

    private void helper(TreeNode leftNode, TreeNode rightNode) {
        
        if(leftNode == null && rightNode == null) return ;
      
        if(leftNode == null || rightNode == null || leftNode.val != rightNode.val)
        {
            isValid = false;
            return;
        }
        
        helper(leftNode.left,rightNode.right);
        helper(leftNode.right,rightNode.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
