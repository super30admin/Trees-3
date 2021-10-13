# Time complexity : O(n) where n is the number of nodes in the tree
# Space complexity : O(n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root):
        if not root:
            return True
        if not root.left and not root.right:
            return True

        return self.symmetricTree(root.left, root.right)

    def symmetricTree(self, root1, root2):
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False
        return root1.val == root2.val and self.symmetricTree(root1.left, root2.right) and self.symmetricTree(root1.right, root2.left)
