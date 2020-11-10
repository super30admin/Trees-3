# Time Complexity : O(n)
# Space Complexity :O(l) where l is number of leaves
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root, sum):
        output = []

        def helper(root, total, temp):
            if not root:
                return

            if not root.left and not root.right and total == sum:
                output.append(temp)
                return
            if root.left:
                helper(root.left, total + root.left.val, temp + [root.left.val])
            if root.right:
                helper(root.right, total + root.right.val, temp + [root.right.val])

        if root:
            helper(root, root.val, [root.val])
        return output
