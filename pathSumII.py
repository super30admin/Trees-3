"""
DFS -
1. Perform DFS
2. Maintain an array to keep track of path
TC - O(n)
SC - O(n)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None: return []

        def dfs(node, target):
            # base
            if not node: return []
            if not node.left and not node.right and target == node.val:
                return [[node.val]]

            # logic
            left = dfs(node.left, target - node.val)
            right = dfs(node.right, target - node.val)

            return [x + [node.val] for x in left + right]

        return [s[::-1] for s in dfs(root, targetSum)]
