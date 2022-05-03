# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


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

        def findSum(total, path, node, result):
            if not node:
                return
            total = total + node.val
            path.append(node.val)
            if not node.right and not node.left:
                if total == targetSum:
                    result.append(list(path))
            if node.left:
                findSum(total, path, node.left, result)
            if node.right:
                findSum(total, path, node.right, result)

            path.pop(-1)

        result = list()
        findSum(0, [], root, result)
        return result
