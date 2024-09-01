from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        left = deque([root.left])
        right = deque([root.right])

        while left and right:
            leftnode = left.popleft()
            rightnode = right.popleft()

            if leftnode is None and rightnode is None:
                continue
            if leftnode is None or rightnode is None:
                return False
            if leftnode.val != rightnode.val:
                return False
            left.append(leftnode.left)
            left.append(leftnode.right)
            right.append(rightnode.right)
            right.append(rightnode.left)
        return True
        