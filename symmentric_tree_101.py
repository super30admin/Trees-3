# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True

        def IsTrue(left, right):
            if left == None and right == None:
                return True

            if (left != None and right == None) or (left == None and right != None):
                return False

            if left.val != right.val:
                return False

            return IsTrue(left.left, right.right) and IsTrue(left.right, right.left)

        return IsTrue(root.left, root.right)
