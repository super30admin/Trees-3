# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root == None):
            return True
        
        return self.compare(root.left, root.right)
    
    def compare(self, p1, p2):
        if(p1 == None and p2 == None):
            return True
        
        if(p1 == None or p2 == None or p1.val != p2.val):
            return False
        
        return self.compare(p1.left, p2.right) and self.compare(p1.right, p2.left)
