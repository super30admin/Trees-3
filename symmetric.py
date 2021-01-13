'''
Time Complexity : O(n)
Space Complexity: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if(root==None):
            return True
        
        def traverse(root1, root2):
            if(root1==None and root2==None):
                return True
            if(root1==None or root2==None):
                return False
            if(root1.val!=root2.val):
                return False
            
            return traverse(root1.left, root2.right) and traverse(root1.right, root2.left)
            
        return traverse(root.left, root.right)
