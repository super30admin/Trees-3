# problem 2 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def check(self,left_node,right_node):
        if left_node and not right_node:
            return False 
        if not left_node and right_node:
            return False
        if not left_node and not right_node:
            return True
        if left_node.val != right_node.val:
            return False
        return self.check(left_node.right,right_node.left) and self.check(left_node.left,right_node.right)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True 
        return self.check(root.left,root.right)