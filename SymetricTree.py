"""
//Time Complexity : O(n)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
        
        if root == None:
            return True
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        
        while(len(stack)!=0):
            right = stack.pop()
            left = stack.pop()
            if right == None and left == None :
                continue
            if right == None or left == None or left.val!=right.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            
            stack.append(left.right)
            stack.append(right.left)
        return True
            
    #     #T.C = o(n)
    #     #S.C = o(h)
    #     if root ==None :
    #         return True
    #     return self.helper(root.left,root.right)
    # def helper(self,left,right):
    #     if left == None and right == None:
    #         return True
    #     if left == None or right==None or left.val != right.val:
    #         return False
    #     return self.helper(left.left,right.right) and self.helper(left.right,right.left)
    
    
    