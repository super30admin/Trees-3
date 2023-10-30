# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        """
        Time Complexity: O(n)
        Space Complexity: O(h)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - We compare the left.left with right.right and left.right with right.left
            - if it's different then we return false
        """      
        if root == None:
            return
        self.symmetric = True
        self.helper(root.left, root.right)
        return self.symmetric
    
    def helper(self, left, right):
        if left == None and right == None:
            return
        if left == None or right == None or left.val != right.val:
            self.symmetric = False
            return
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)