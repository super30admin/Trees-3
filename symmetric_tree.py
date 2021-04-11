# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of tree and stack space for recursion
# Ran on Leetcode: Yes

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
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        if not left and not right:
            return True
        if not left or not right or left.val != right.val:
            return False
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)