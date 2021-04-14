/**Leetcode Question 101 - Symmetric Tree */
/**Algorithm - Recursion
 * Pass the left and the right child recursively to check if they are same
 */
/**TC- O(N) - Number of nodes
 * SC- O(H) - Height of the tree
 */
public class SymmetricTree {
    class Solution {
        boolean isValid;
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            isValid = true;
            helper(root.left,root.right);
            return isValid;
        }
        private void helper(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return;
            }
            if(left == null || right == null || left.val!= right.val){
                isValid = false;
                return;
            }
            helper(left.left, right.right);
            helper(left.right, right.left);
        }
    }
}

/**Iterative Solution */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty()){
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null || left.val != right.val){
                return false;
            }
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
}