# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Compare the left and right subtrees recursively by checking if
# their root values match and their outer and inner children are mirror images of each other.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        return self.isSymmetricHelper(root.left, root.right)

    def isSymmetricHelper(self, leftNode, rightNode) -> bool:
        if (leftNode is None and rightNode is not None) or (leftNode is not None and rightNode is None):
            return False

        if leftNode is None and rightNode is None:
            return True

        is_outer = self.isSymmetricHelper(leftNode.left, rightNode.right)
        is_inner = self.isSymmetricHelper(leftNode.right, rightNode.left)

        if leftNode.val == rightNode.val and is_outer and is_inner:
            return True

        return False



        