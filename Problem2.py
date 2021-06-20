# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, left: TreeNode, right: TreeNode) -> bool:
        if left != None and right != None:
            
            return left.val == right.val and self.helper(left.left, right.right) and self.helper(left.right, right.left)
        else:
            return left == right
            
    
    
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return true
        
        return self.helper(root.left, root.right)
        