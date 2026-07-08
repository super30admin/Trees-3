class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(left.right, right.left)

# TC - O(n)
# SC - O(h) where h - height of tree.