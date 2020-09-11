# // Time Complexity : O(n), n = number of elements
# // Space Complexity : O(maxdepth)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        #if root is null, return true
        if root == None:
            return True
        
        return self.recur(root.left, root.right)
        
        
    def recur(self, leftP1: TreeNode, rightP2: TreeNode) -> bool :
        
        #check if both of roots is null, return true
        if  leftP1==None and rightP2==None:
            return True
        
        #check if any of the branch value doesn't match 
        #or if one side is null and another isn't, return false
        if leftP1 == None or rightP2 == None or leftP1.val != rightP2.val:
            return False
        
        # now return True only if both side of the tree recursively gives same values for:
        #left tree's left child == right tree's right child and
        #left tree's right child == right tree's left child
        return self.recur(leftP1.left, rightP2.right) and self.recur(leftP1.right, rightP2.left)
    
        
        
        