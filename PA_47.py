#LC 101 - Symmetric Tree
#Time Complexity - O(n)
#Space Complexity - O(2n)
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
        def helper(root1,root2):
            if not root1 and not root2:
                return True
            if root1 and not root2:
                return False
            if not root1 and root2:
                return False
            if root1.val != root2.val:
                return False
            return helper(root1.left,root2.right) and helper(root1.right,root2.left)
        return helper(root,root)