// TC - O(n), SC - O(n) - stack calls

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

class Solution{
    public boolean isSymmetric(TreeNode root) {
        // calling a method, with 2 root nodes. these act as two different trees
        return isSymmetric(root, root);       
    }
    
    private boolean isSymmetric(TreeNode node1, TreeNode node2){
        // If both nodes are null, we will return true, as both are equal.
        if(node1 == null && node2 == null)
            return true;
        // if one of the nodes is null or node1.val not equal to node2.val, return false
        if((node1 == null || node2 == null) || (node1.val != node2.val)){
            return false;
        }
        // call methods
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        
    }
}


// class Solution{
//     public boolean isSymmetric(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         q.add(root);
//         while(!q.isEmpty()){
//             TreeNode node1 = q.poll();
//             TreeNode node2 = q.poll();
//             if(node1 == null && node2 == null){
//                 continue;
//             }
//             if(node1 == null || node2 == null){
//                 return false;
//             }
//             if(node1.val != node2.val){
//                 return false;
//             }
//             q.add(node1.left);
//             q.add(node2.right);
//             q.add(node1.right);
//             q.add(node2.left);
//         }
//         return true;
//     }
// }
