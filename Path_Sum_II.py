# TC: O(n)
# SC: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy
class Solution:
    def __init__(self):
        self.resultArray = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []

        self.dfs(root, 0, targetSum, current = [])
        return self.resultArray

    def dfs(self, root, currentSum, targetSum, current):
        if root == None:
            return

        current.append(root.val)
        currentSum += root.val
        if root.left == None and root.right == None:
            if currentSum == targetSum:
                self.resultArray.append(copy.deepcopy(current))

        self.dfs( root.left, currentSum, targetSum, current)
        self.dfs( root.right, currentSum, targetSum, current)
        current.pop()
