# 101. Symmetric Tree

# Time Complexity: O(n)
# Space Complexity: O(h) - h can be n in the worst case
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use DFS to check if the tree is symmetric.
# Use a helper function to pass the left and right subtrees.
# If the left and right subtrees are symmetric, return True.
# Otherwise, return False.

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        def isMirror(t1: TreeNode, t2: TreeNode) -> bool:

            if t1 is None and t2 is None: 
                return True

            if t1 is None or t2 is None: 
                return False

            return t1.val == t2.val and isMirror(t1.right, t2.left) and isMirror(t1.left, t2.right)
        
        return isMirror(root, root)
    
