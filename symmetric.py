# Time Complexity : O(N) 
# Space Complexity :    O(H)  - height of tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root==None:
            return False
        
        return self.helper(root.left,root.right)
    
    
    def helper(self,rleft,rright):
        if rleft==None and rright==None:
            return True
        
        if rleft==None or rright==None or rleft.val!=rright.val:
            return False
        
        case1 = self.helper(rleft.left,rright.right)
        case2 = self.helper(rleft.right,rright.left)
        
        return case1 and case2