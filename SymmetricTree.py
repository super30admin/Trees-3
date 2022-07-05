#101. Symmetric Tree
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag = True
    def helper(self, root1, root2):
        if root1 == None and root2 == None:
            return
        
        if root1 == None or root2 == None:
            self.flag = False
            return
            
        if root1.val != root2.val:
            self.flag = False

        self.helper(root1.left, root2.right)
        self.helper(root1.right, root2.left)
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #null
        if root == None:
            return True
        
        
        
        self.helper(root.left, root.right)
        #print(self.flag)
        return self.flag
