# time: O(n)
# Space: O(1)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        return self.helper(root.left, root.right)
    
    def helper(self, b1, b2):
        if not b1 and not b2:
            return True
        if not b1 or not b2:
            return False
        return (b1.val == b2.val) and self.helper(b1.left, b2.right) and self.helper(b1.right, b2.left)