# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space COmplexity: O(n)
class Solution(object):

    def checkBT(self, root, root1):

        #         check if both roots are null , of then both are symmetric
        if not root and not root1:
            return True
        #         If onr of them is null then it is not symmetric
        if not root or not root1:
            return False

        # Return result when current one root value is equal
        # to second root value and same for ots left and right subtree
        return root.val == root1.val and self.checkBT(root.left, root1.right) and self.checkBT(root.right, root1.left)

    def isSymmetric(self, root):
        #         In the start assign second root to current root only and call the recursive function
        root1 = root
        return self.checkBT(root, root)

        """
        :type root: TreeNode
        :rtype: bool
        """
