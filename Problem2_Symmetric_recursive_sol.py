# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity O(N) where N is number of nodes in the tree
# Space complexity O(H) where H is height of the tree
class Solution(object):
    def check(self, left, right):
        if left is None and right is None:
            return True
        elif left is None or right is None or left.val!=right.val:
            return False
        return self.check(left.left, right.right) and self.check(left.right, right.left)

    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        return self.check(root.left, root.right)