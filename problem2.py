# Time Complexity : O(n), n-> nodes in tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def symmCheck(p,q):
            if not p and not q:
                return True
            elif p and not q or q and not p:
                return False
            left = symmCheck(p.left, q.right)
            right = symmCheck(p.right, q.left)
            return left and right and p.val == q.val
        
        return symmCheck(root.left, root.right)