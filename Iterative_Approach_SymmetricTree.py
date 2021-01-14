# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes


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
        stack=[[root.left,root.right]]
        while(stack!=[]):
            left,right=stack.pop()
            if(left==None and right==None):
                continue
            if(left==None or right==None or left.val!=right.val):
                return False
            stack.append([left.left,right.right])
            stack.append([left.right,right.left])
        return True
            
        
        