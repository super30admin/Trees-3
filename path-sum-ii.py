# Time Complexity : O(n) + O(kh)- n is number of nodes in tree,
#                                 k is the number of paths where sum = targetSum
#                                 h is height of tree, max length to create a copy of list while adding that list to result
# Space Complexity : O(n) + O(kh) - n is number of nodes in tree, for recursion stack
#                                 k is the number of paths where sum = targetSum
#                                 h is height of tree, max length to create a copy of list while adding that list to result
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
We pass the path list and current sum upto that node to each recursive call
If current Sum == target sum, we add the path list to the main result list,
but while adding we create a new copy of path list and then add it to the result list as
path list is passed by reference for every recursive call, so it's state can change
even after we add it to the results list.
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
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """

        self.result = []
        self.helper(root, [], 0, targetSum)
        return self.result


    def helper(self, root, path, currSum, targetSum):

        if root is None: return

        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if currSum == targetSum:
                pathCopy = list(path)
                self.result.append(pathCopy)

        self.helper(root.left, path, currSum, targetSum)
        self.helper(root.right, path, currSum, targetSum)
        path.pop()
