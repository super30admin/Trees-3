# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # Time Complexity - O(N)
        # Space Complexity - 2O(log N) because of stack space
        # Algorithm - Checking if the left value of left is equal to right of right and 
        #             right of left is equal to left of right for all levels. Start this keeping
        #             left and right to be root

        if root == None:
            return True
        
        return self.helper(root,root)
        
        
    def helper(self,left,right):
        
        if left == None and right == None:
            return True
        
        if left==None or right == None:
            return False
        
        if left.val != right.val:
            return False
        
        return self.helper(left.left,right.right) and self.helper(left.right,right.left)