/*
This program uses a BFS approach to solve the problem. For checking the symmetry of the tree, it uses two conditions.
The first condition is if the left child of the leftmost node is equal to the right child of the rightmost node, and 
the second condition is if the right child of the leftmost node is equal to the left child of the rightmost node. The
nodes to be checked are stored as pairs in a Queue data structure, to make for easier handling of data.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        //Since root node is already symmetrical we start from its left and right children
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty())
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            //If both the childs are null, then we simply continue to the next pair of values, as both childs being null is also a symmetry
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        
        return true;
    }
}