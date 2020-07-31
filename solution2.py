# // Time Complexity : o(n)
# // Space Complexity : o(h)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : space complexity, don't forget nodes will be stacked per each recursion
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.dfs(root.left, root.right)

    def dfs(self, node1, node2):
        if not node1 and not node2:
            return True

        if not node1 or not node2 or node1.val != node2.val:
            return False

        return self.dfs(node1.left, node2.right) and self.dfs(node1.right, node2.left)
