# Time Complexity : O(n)
# Space Complexity : O(h) for the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# In the symmetric tree, we need to handle the far end of the subtrees and also the near end of the subtree
# The recursion then checks for equality of the values and also if both are null.
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        def helper(lRoot, rRoot):
            if not lRoot or not rRoot:
                return lRoot == rRoot
            return lRoot.val == rRoot.val and helper(lRoot.left, rRoot.right) and helper(lRoot.right, rRoot.left)
        
        return helper(root.left, root.right)