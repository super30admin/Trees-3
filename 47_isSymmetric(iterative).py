# passed on leetcode
# iterative approach using stack
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        while len(stack) > 0:
            right = stack.pop()
            left = stack.pop()
            if right is None and left is None:
                continue
            if right is None or left is None or left.val != right.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True