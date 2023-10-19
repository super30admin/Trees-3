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
        # Time Complexity: O(N)
        # Space Complexity: O(N)

        def validateTree(leftTree, rightTree):
            if not leftTree and not rightTree: return True
            if (not leftTree) or (not rightTree): return False

            if leftTree.val != rightTree.val: return False
            left = validateTree(leftTree.left, rightTree.right)
            if not left: return False
            right = validateTree(leftTree.right, rightTree.left)
            return right

        return validateTree(root.left, root.right)



