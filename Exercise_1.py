# ## Problem1 (https://leetcode.com/problems/path-sum-ii/)
# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Using backtracking
class Solution:
    def pathSum(self, root, targetSum):
        # result list
        self.result = []
        # calling the recursion function
        self.helper(root, 0, targetSum, [])
        return self.result

    def helper(self, root, currSum, targetSum, path):
        # base case
        if root is None:
            return
        # logic
        currSum += root.val
        # action --> adding root val to list path
        path.append(root.val)
        # checking if leaf node
        if root.left is None and root.right is None:
            # checking if curr sum is equal to target sum
            if currSum == targetSum:
                # appending a deep copy of the list
                self.result.append(list(path))

        # recursion
        self.helper(root.left, currSum, targetSum, path)
        self.helper(root.right, currSum, targetSum, path)

        # backtrack
        path.pop()


# Creating a deep copy of path each time
# class Solution:
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         self.result = []
#         self.helper(root, 0, targetSum, [])
#         return self.result

#     def helper(self, root, curr_sum, targetSum, path):
#         # base
#         if root is None:
#             return
#         # logic
#         curr_sum += root.val
#         path.append(root.val)
#         if (root.left is None and root.right is None):
#             if curr_sum == targetSum:
#                 print('curr_sum: ', curr_sum)
#                 print('path: ', path)
#                 self.result.append(path)

#         self.helper(root.left, curr_sum, targetSum, list(path))
#         self.helper(root.right, curr_sum, targetSum, list(path))
