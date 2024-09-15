/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** DFS
 * Time Complexity - O(n)
 * Space Complexity - O(Logn) - With recursive stack
 *                    O(1) - Without recursive stack
 */
/** BFS
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 */
class Solution {

    public boolean isSymmetric(TreeNode root) {

        if(root==null)
            return true;
        // return recursive(root.left, root.right);

        return iterative(root);

    }

    private boolean iterative(TreeNode  root){

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){

            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2==null)
                continue;

            if(t1 == null || t2== null)
                return false;

            if(t1.val != t2.val)
                return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;

    }


    private boolean recursive(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null)
            return false;

        return left.val == right.val && recursive(left.left, right.right) && recursive(left.right, right.left);
    }

}