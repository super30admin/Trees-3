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
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// check for the left of left and right of right, and return false if both left and right value are not same
// Your code here along with comments explaining your approach
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if( root == null) return true;
        return bfs(root.left, root.right);
    }
    private boolean bfs(TreeNode left, TreeNode right){
        //base
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val ) return false;
        //logic
        boolean lSide = bfs(left.left, right.right);
        boolean rSide = bfs(left.right, right.left);
        if(left.val == right.val && lSide && rSide){
            return true;
        }else{
            return false;
        }
    }
}

// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         //null
//         if( root == null ) return true;
//         Queue<TreeNode> q1 = new LinkedList<>();
//         ArrayDeque<TreeNode> dq = new ArrayDeque<TreeNode>();
//         TreeNode dummy = new TreeNode(500);
//         q1.add(root);
//         // add innitial value
//         while(!q1.isEmpty()){
//             root = q1.remove();
//             if(root != null){
//                 if( root.left != null){
//                     dq.add(root.left);
//                 }else{
//                     dq.add(dummy);
//                 }
//                 if( root.right != null){
//                     dq.add(root.right);
//                 }else{
//                     dq.add(dummy);
//                 }
//                 if(q1.size() == 0){
//                     //System.out.println(dq.val);
//                     if(helper(new ArrayDeque<TreeNode>(dq))) return false;
//                     q1.addAll(dq);
//                     dq.clear();
//                 }
//             }
//         }
//         return true;
//     }
//     private boolean helper(ArrayDeque<TreeNode> dq){
//         while(!dq.isEmpty()){
//             if(dq.removeFirst().val == dq.removeLast().val){
//                continue;
//             }else{
//                return true;
//             }
//         }
//         return false;
//     }
// }