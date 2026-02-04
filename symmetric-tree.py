''' 
Time Complexity : O(n) 
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
    
    def helper(self, left, right):
        # base
        if left is None and right is None:
            return
        
        if left is None or right is None or left.val != right.val:
            self.flag = False
            return

        # logic
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        self.helper(root.left, root.right)

        return self.flag
        