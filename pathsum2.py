# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def dfs(self, root, targetSum, currSum, path):
        if root is None:
            return

        currSum += root.val
        path.append(root.val)
        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(list(path))

        self.dfs(root.left, targetSum, currSum, path)
        self.dfs(root.right, targetSum, currSum, path)
        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.dfs(root, targetSum, 0, [])
        return self.result
