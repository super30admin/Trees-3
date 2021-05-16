"""
Intuition: Recursively call left.left and right.right  AND left.right and right.left 
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(H)
#####################################################################
"""

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

        return self.helper(root.left,root.right)

    def helper(self,leftChild,rightChild):

        #Base
        if leftChild == None and rightChild == None:
            return True

        #Logic

        if leftChild == None or rightChild == None or leftChild.val != rightChild.val:
            return False
    
        return self.helper(leftChild.left,rightChild.right) and self.helper(leftChild.right,rightChild.left)