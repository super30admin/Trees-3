# Time Complexity : O(n)
# Space Complexity : O(n) if stack space is considered
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I use recursion to check if left subtree is equal to right subtree
# Considering null == null if one element is null, we return false

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True
        def helper(left, right):
            if not left and not right:
                return True
            if (not left and right) or (not right and left):
                return False
            return left.val == right.val and helper(left.left, right.right) and helper(left.right, right.left)
        
        return helper(root.left, root.right)