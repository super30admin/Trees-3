# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root, targetSum):
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self, root, targetSum, currSum, temp):
        if not root:
            return
        temp.append(root.val)
        currSum = currSum + root.val
        if not root.left and not root.right and currSum == targetSum:
            self.result.append(list(temp))
        self.helper(root.left, targetSum, currSum, temp)
        self.helper(root.right, targetSum, currSum, temp)
        temp.pop()
