//Time Complexity: O(n^2)
//Space Complexity: O(n)with recursive stack
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem47 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        boolean value = checkSubTrees(root.left, root.right);

        return value;
    }


    //recurive approach
    boolean checkSubTrees(TreeNode leftNode, TreeNode rightNode){

        if(leftNode == null && rightNode == null)
            return true;
        if((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null))
            return false;
        if(leftNode.val != rightNode.val)
            return false;

        return (leftNode.val == rightNode.val) && checkSubTrees(leftNode.left, rightNode.right) && checkSubTrees(leftNode.right, rightNode.left );

    }

}
