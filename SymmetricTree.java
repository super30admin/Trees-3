Recursive Approach

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

/**
TC - O(N) where N is the number of nodes in a tree.
SC - O(H) where H is the height of the tree.

**/
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        
            if (root == null)
            {
                return true;
            }

            return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode actual, TreeNode mirror)
    {
        if (actual == null && mirror == null)
        {
            return true;
        }
        
        if (actual == null && mirror != null)
        {
            return false;
        }
        
        if (actual != null && mirror == null)
        {
            return false;
        }
        
        if (actual.val != mirror.val)
        {
            return false;
        }
        
        boolean isSymmetricLeft = isSymmetricHelper(actual.left, mirror.right);
        
        if (!isSymmetricLeft)
        {
            return false;
        }
        
        boolean isSymmetricRight = isSymmetricHelper(actual.right, mirror.left);
        
        return isSymmetricLeft && isSymmetricRight;
    }
}

/**
Iterative Approach:



**/

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

/**
TC - O(N) where N is the number of nodes in a tree.
SC - O(N) where N is the size of queue.

**/
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        
         if (root == null)
         {
            return true;
         }
    
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        
        while(!queue.isEmpty())
        {
            TreeNode pop1 = queue.remove();
            TreeNode pop2 = queue.remove();
            
            if (pop1 == null && pop2 == null)
            {
                continue;
            }
            
            if (pop1 != null && pop2 == null)
            {
                return false;
            }
            
            if (pop1 == null && pop2 != null)
            {
                return false;
            }
            
            if (pop1 != null && pop2 != null && pop1.val != pop2.val)
            {
                return false;
            }
            
            queue.add(pop1.left);
            queue.add(pop2.right);
            queue.add(pop1.right);
            queue.add(pop2.left);
        }
            
        return true;
    }
}
