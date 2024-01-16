""" Explanation: Used dfs to access the nodes and recursion to get the sum. The two lists store the path and the final result since the
    output needs to be a list.
    Time Complexcity: O(n)
    Space COmplexcity: O(n)
    Code passed all cases on LC: Yes
"""


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
        result = []
        path = []
        self.dfs(root, targetSum, path, result)
        return result

    def dfs(self, node, target, path, result):
        if not node:
            return
        path.append(node.val)
        if not node.left and not node.right and node.val == target:
            result.append(path[:])
        self.dfs(node.left, target - node.val, path, result)
        self.dfs(node.right, target - node.val, path, result)
        path.pop()