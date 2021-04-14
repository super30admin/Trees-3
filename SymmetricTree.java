/**
 *
 *  Time Complexity: O(N) Where N is the number of nodes in the tree.
 *  Space Complexity: O(N) It would take O(N) space in worst case(linear tree) and log(N) space in averge case, where log(N) represent height of the tree.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: We can use DFS to solve the problem. We can have a helper function which could take in two treeNodes left and right. Now we have a base condition to check if these nodes are both null then we return true, else if only one is null or if both the value are not matching we return false. If both the left and right node are equal the we try to recursively check the left.right with right.left and left.left with right.right. If we enounter any case where its not symmetric then we return false else true.
 */
class Solution {
    
    // DFS - inorder Recursive
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
    
    // DFS - inorder Iterative
    // public boolean isSymmetric(TreeNode root) {
    //     if(root==null)return true;
    //     if(root.left==null && root.right==null) return true;
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.add(root.left);
    //     stack.add(root.right);
    //     while(!stack.isEmpty()){
    //         TreeNode left = stack.pop();
    //         TreeNode right = stack.pop();
    //         if(left==null && right==null) {
    //             continue;
    //         }
    //         if(left==null || right==null || left.val!=right.val){
    //             return false;
    //         }
    //         stack.push(left.right);
    //         stack.push(right.left);
    //         stack.push(left.left);
    //         stack.push(right.right);
    //     }
    //     return true;
    // }
    
}
