"""
https://leetcode.com/problems/path-sum-ii/
Path Sum 2
Approach:
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root, targetSum: int):
        self.result = []
        currsum = 0
        self.target = targetSum
        self.helper(root, [], currsum)
        print(self.result)
        return self.result

    def helper(self, root, path, currsum):
        ##base
        if root == None:
            return

            ##logic
        currsum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currsum == self.target:
                self.result.append(path)
        self.helper(root.left, list(path), currsum)
        ##stack.pop is happening here
        self.helper(root.right, list(path), currsum)

