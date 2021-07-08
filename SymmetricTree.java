// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Initiate two pointers, root 1 and root 2. One will track the left side and other
will check the right side if they are same or not. Hence, initiate both the pointers from the root, according to the symmetricity, if the left side of left subtree is same as 
right side of right subtree or vice versa, they are symmetric. If anything is not same while we check on the path, return false. 
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
    if(root == null) {return true;}
    return isSame(root, root);
    }
    
    private boolean isSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){                             // if both are null, they are same
            return true;
        }
        else if(root1 == null || root2 == null){                        // If either of them is null, they are not same.
            return false;
        }
        if(root1.val==root2.val && isSame(root1.left, root2.right) && (isSame(root1.right, root2.left))){           // they should be equal and recursively run both the pointers in different directions as per symmetricity
            return true;
        }
        return false;               // If not true then return false
    }

    /*   ITERATIVE:

    public boolean isSymmetric(TreeNode root) {
        if(root == null) { return true;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);                                // Add the root to the queue
        queue.add(root);
        while(queue.size() > 0){
            TreeNode root1 = queue.poll();                          // Root 1 is getting ready to go to left side
            TreeNode root2 = queue.poll();                          // Root 2 is getting ready to goto right side
           if(root1 == null && root2 == null){continue;}            // If both are null, we are not done yet!
            if(root1 == null || root2 == null){return false;}       // If any mismatch on the way => False
            if(root1.val != root2.val){return false;}
            queue.add(root1.left);                                  // Push the left node of current node root 1
            queue.add(root2.right);                                 // Push the right node of current node root 2
            queue.add(root1.right);                                 // push the right node of current node root 1
            queue.add(root2.left);                                  // Push the left node of current node root 2..
            }                                                   // Push the required because we cant come back as we move along. we are checking simultaneously root 1 and root 2
            return true;
        }
    }
    */

}