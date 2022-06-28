# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    '''Time Complexity: O(n)
    Space Complexity: O(h)'''
    
    def dfs(self, left, right):
        #if both the roots are null
        if left is None and right is None:
            return True
        #if one of them is null or if the values are different
        if left is None or right is None or left.val != right.val:
            return False
        
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)
        
        
    
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #Using dfs
        if not root:
            return True
        
        return self.dfs(root.left, root.right)
        
        
