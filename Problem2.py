'''
1. We check for each level on 3 conditions. 
2. If both children are None, we return True. If only one of the children is None, we return False
3. If both the children are not None, we check if the values are equal. 
4. We check if the left child's left is equal to the right child's right and the left child's right is equal to the right child's left.

TC: O(n)
SC: O(n) - recursive stack
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        if root == None:
            return True

        return self.isSame(root.left,root.right)

    def isSame(self,left,right):
        if left == None and right == None:
            return True
        if left == None or right == None:
            return False
        if left.val != right.val:
            return False


        return self.isSame(left.left,right.right) and self.isSame(left.right,right.left)
        
        

        

