# time complexity is o(n), where n is the size of the input
# space complexity is o(h), h = log(n), where n is the size of the input
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root,root)    
    def helper(self, lroot, rroot):
        if(lroot == None and rroot == None):
            return True
        if(lroot == None or rroot == None):
            return False
        if(self.helper(lroot.left, rroot.right) == False):
            return False
        
        return self.helper(lroot.right, rroot.left) and lroot.val == rroot.val
        