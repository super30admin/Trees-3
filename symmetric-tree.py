# Time Complexity : O(n) - n is number of nodes in tree,
# Space Complexity : O(h) - h is height of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
check if right subtree of tree is mirror reflection of left subtree of the tree
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        self.isSymmetric = True
        self.helper(root, root)
        return self.isSymmetric

    def helper(self ,r1, r2):
        if r1 is None and r2 is None: return

        if r1 is None or r2 is None:
            self.isSymmetric = False

        if self.isSymmetric and r1.val != r2.val:
            self.isSymmetric = False

        if self.isSymmetric:
            self.helper(r1.left, r2.right)

        if self.isSymmetric:
            self.helper(r1.right, r2.left)