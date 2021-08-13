"""
Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode :
Any problem you faced while coding this :
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.helper(root.left, root.right)
    def helper(self, node1, node2):
        # If both are null return True
        if node1 == None and node2 == None:
            return True
        elif node1 == None or node2 == None:
            return False
        # Check, if value are equal and their children are equal too
        else:
            return (node1.val == node2.val) and self.helper(node1.right, node2.left) and self.helper(node1.left, node2.right)