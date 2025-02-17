# Approach:
# Use recursion to check if the left and right subtrees are mirror images by comparing corresponding nodes.
# Ensure symmetry by verifying left.left == right.right and left.right == right.left at every step.
# Time Complexity: O(n) 
# Space Complexity:O(h) 
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
            return self.isMirror(root, root)

    def isMirror(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        return (left.val == right.val) and self.isMirror(left.left, right.right) and self.isMirror(left.right, right.left)
        