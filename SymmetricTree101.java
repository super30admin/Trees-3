import java.util.LinkedList;
import java.util.Queue;

//time complexity : O(n)
//space complexity :  O(n)
//leet code execution : successful
//steps : created helper function for traversal for left and right sub trees. recurrsion returns true only when left and right subtree vals match.
class SymmetricTree101 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }}


    public boolean isSymmetric(TreeNode root){
        //if(root==null) return true;
        //return helper(root.left,root.right);

        if(root==null){
            return true;
        }

        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode nodeA,nodeB;
            nodeA = queue.poll();
            nodeB = queue.poll();

            if(nodeA==null && nodeB==null) continue;
            if(nodeA==null||nodeB==null)return false;
            if(nodeA.val!=nodeB.val) return false;
            queue.add(nodeA.left);
            queue.add(nodeB.right);
            queue.add(nodeA.right);
            queue.add(nodeB.left);
        }
        return true;
        }

/**
	private boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null ){
            return true;    
        }
        if(left==null||right==null||left.val!=right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
    */

}