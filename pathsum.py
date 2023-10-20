#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        self.dfs(root, 0, targetSum, path, result)
        return result

    def dfs(self, root, pathSum, targetSum, path, result):
        if root is None:
            return

        pathSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None and pathSum == targetSum:
            result.append(path[:])  # Append a copy of the path to result

        self.dfs(root.left, pathSum, targetSum, path, result)
        self.dfs(root.right, pathSum, targetSum, path, result)

        # Backtrack by removing the last element from the path and subtracting its value from pathSum
        path.pop()
