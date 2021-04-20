class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:

        if root is None:
            return True
        return self.is_mirror(root.left, root.right)

    def is_mirror(self, left_root, right_root):
        if left_root and right_root:
            return (left_root.val == right_root.val) and self.is_mirror(
                left_root.left, right_root.right) and self.is_mirror(
                    left_root.right, right_root.left)
        return left_root == right_root
