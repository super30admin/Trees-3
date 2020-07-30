# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I am using inorder traversal by passing two instaces of the root node to recursively check
    left of left subtree and right of right subtree AND Right of left Subtree and left of RightSubtree
'''

class Solution:
    
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        return self._helper(root, root)   
        
  
    def _helper(self, root1, root2):
        
        if root1 is None and root2 is None:
            return True
            
        if root1 is None or root2 is None:
            return False

        if (self._helper(root1.left, root2.right) == False):
            return False
        
        print (root1.val, root2.val)
        if root1.val != root2.val:
            return False
        
        return self._helper(root1.right, root2.left)

        