//Recursive
//Time Complexity : O(n)
//Space Complexity : O(h). h is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    boolean isValid;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        isValid = true;
        //at each level compare the current nodes left and current nodes right
        helper(root.left,root.right);
        return isValid;
    }
    private void helper(TreeNode nodeleft, TreeNode noderight){
        if(nodeleft==null && noderight==null){
            return;
        }
        //if either of the values are null or if the left and right values dont match then its not symmetric
        if(nodeleft==null || noderight==null || nodeleft.val!=noderight.val){
            isValid = false;
            return;
        }
        //continue with the next level
        helper(nodeleft.left,noderight.right);//compare left's node left with right nodes right
        helper(nodeleft.right,noderight.left);//compare left's node right with right nodes left
    }
}
//Iterative
//Time Complexity : O(n)
//Space Complexity : O(h). h is height of the tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode nodeleft = stack.pop();
            TreeNode noderight = stack.pop();
            //if both are null continue to visit the rest of the nodes in the other levels
            if(nodeleft==null && noderight==null){
                continue;
        }
        //if either of the values are null or if the left and right values dont match then its not symmetric
        if(nodeleft==null || noderight==null || nodeleft.val!=noderight.val){
            return false;
        }
            //continue with the next level
            stack.push(nodeleft.left);
            stack.push(noderight.right);
            stack.push(nodeleft.right);
            stack.push(noderight.left);
        }
        return true;
    }
}