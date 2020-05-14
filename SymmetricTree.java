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
}