# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        def dfs(node, path, curr_sum):
            if not node:
                return
            path.append(node.val)
            curr_sum += node.val
            if not node.left and not node.right:
                if curr_sum == targetSum:
                    res.append(list(path))
            else:
                dfs(node.left, path, curr_sum)
                dfs(node.right, path, curr_sum)
            path.pop()
        dfs(root, [], 0)
        return res
        