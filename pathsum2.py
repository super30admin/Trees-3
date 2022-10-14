##Time Complexity : O(n)
##Space Complexity : O(n)
##Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if not root:
            return []
        if not root.left and not root.right and targetSum == root.val:
            return [[root.val]]
        left_path = self.pathSum(root.left, targetSum-root.val)
        right_path = self.pathSum(root.right, targetSum-root.val)
        left = [[root.val]+l for l in left_path]
        right = [[root.val]+r for r in right_path]
        return left+right
       