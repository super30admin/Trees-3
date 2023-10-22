# TC : O(N)
# SC : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False

        stack = [(root.left, root.right)]
        while stack:
            left_tree, right_tree = stack.pop()
            if not left_tree and not right_tree:
                continue
            if not left_tree or not right_tree:
                return False
            if left_tree.val != right_tree.val:
                return False
            stack.append((left_tree.right, right_tree.left))
            stack.append((left_tree.left, right_tree.right))
        
        return True

              