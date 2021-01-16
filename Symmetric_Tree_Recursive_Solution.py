# Created by Aashish Adhikari at 11:00 PM 1/15/2021

'''
Time Complexity:
O(n) where n is the number of nodes in the tree.

Space Complexity:
O(1)

'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, left, right):

        # base case
        if left is None and right is None:
            return True

        if left is None or right is None:
            return False

        if left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(left.right, right.left)





    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        if root is None:
            return True

        return self.helper(root.left, root.right)