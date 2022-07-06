# Time Complexity : O(v+e)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        paths = []
        if not root:
            return []

        def dfs(root, cur):
            if not root.left and not root.right:
                cur += [root.val]
                paths.append(cur)
                return
            if root.left:
                dfs(root.left, cur + [root.val])
            if root.right:
                dfs(root.right, cur + [root.val])

        dfs(root, [])
        res = []

        for path in paths:
            if sum(path) == targetSum:
                res.append(path)
        return res
