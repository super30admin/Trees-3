# Time Complexity : O(n)
# Space Complexity : O(n)
from collections import deque

class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True
        queue = deque([root.left, root.right])
        while queue:
            left = queue.popleft()
            right = queue.popleft()
            if left is None and right is None:
                continue
            if left is None or right is None or left.val != right.val:
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

solution = Solution()

# Example 1:
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(2)
root.left.left = TreeNode(3)
root.left.right = TreeNode(4)
root.right.left = TreeNode(4)
root.right.right = TreeNode(3)
print(solution.isSymmetric(root))  # Expected output: True

# Example 2:
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(2)
root.left.right = TreeNode(3)
root.right.right = TreeNode(3)
print(solution.isSymmetric(root))  # Expected output: False

# Example 3:
root = TreeNode(1)
print(solution.isSymmetric(root))  # Expected output: True