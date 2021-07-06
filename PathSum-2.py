# time: O(n2)
# space : O(N)
# Did this code successfully run on Leetcode : Yes



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        path = []
        self.dfs(root, path, targetSum)
        return self.result

    def dfs(self, root, path, remaining_target):
        # base
        if not root:
            return

        path.append(root.val)

        if root.val == remaining_target and not root.left and not root.right:
            self.result.append(list(path))
        else:
            self.dfs(root.left, path, remaining_target - root.val)
            self.dfs(root.right, path, remaining_target - root.val)

        path.pop()
