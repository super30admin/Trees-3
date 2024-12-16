# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        res = []

        def dfs(curr, path, sum):
            sum += curr.val
            temp = path + [curr.val]

            if curr.left:
                dfs(curr.left, temp, sum)
            if curr.right:
                dfs(curr.right, temp, sum)
            if not curr.left and not curr.right and (sum == targetSum):
                res.append(temp)

        if not root:
            return []
        dfs(root, [], 0)

        return res




