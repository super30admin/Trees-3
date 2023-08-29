// Time Complexity : O(n) -->no.of nodes
// Space Complexity : O(n) --> queue space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);  
        // mirror images from images root and left subtree as image, root and right subtree as mirror image
        queue.add(root);


        while(!queue.isEmpty())
        {
            TreeNode t1= queue.poll(); 
            TreeNode t2 = queue.poll();
            if(t1== null && t2 == null) continue;
            if(t1 ==null || t2 ==null) return false; // if only one of them is null then  they are not mirror images
            if(t1.val!=t2.val) return false;
            queue.add(t1.left); // left child should be comapred to right child of mirror image
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}