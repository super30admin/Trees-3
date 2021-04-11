# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of tree and stack space for recursion
# Ran on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []
        self.sub = []
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        self.helper(root, 0, targetSum)
        return self.res
        
    def helper(self, root, currSum, targetSum):
        if not root:
            return
        self.sub.append(root.val)
        if not root.left and not root.right and currSum + root.val == targetSum:
            self.res.append(self.sub.copy())
        self.helper(root.left, currSum + root.val, targetSum)
        self.helper(root.right, currSum + root.val, targetSum)
        self.sub.pop()
        