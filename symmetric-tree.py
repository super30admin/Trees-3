# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(left, right):
            if not left and not right:
                return True
            elif not left or not right:
                return False
            else:
                return helper(left.right, right.left) and right.val == left.val and helper(left.left, right.right)
        if not root: return True
        return helper(root.left, root.right)