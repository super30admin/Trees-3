# APPROACH 1: RECURSION (WITH NO INORDER)
# Time Complexity : O(n), n: number of nodes of the tree
# Space Complexity : O(lg n) or O(h) - h: height of the tree, space taken up by the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Initially, I pass root's hildren to the recursive way
# 2. Each time, I compare both the roots. If not equal or any of them is empty -> False
# 3. Else, I go left on one side and right on the other side AND right on one side and left on the other side.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        return self.helper(root.left, root.right)
    
    
    def helper(self, root1, root2):
        
        if root1 is None and root2 is None:
            return True
        
        if (root1 is None or root2 is None) or (root1.val != root2.val):
            return False
        
        return self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)
