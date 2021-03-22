# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity: O(n)
# Space complexity: O(1)
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []
        self.final = []
        self.helper(root, [root.val], root.val, targetSum)
        return self.final

    def helper(self, root, temp, currentSum, targetSum):
        if root.left is None and root.right is None and currentSum == targetSum:
            self.final.append(temp)
        if root.left is not None:
            self.helper(root.left, temp + [root.left.val], currentSum + root.left.val, targetSum)
        if root.right is not None:
            self.helper(root.right, temp + [root.right.val], currentSum + root.right.val, targetSum)
