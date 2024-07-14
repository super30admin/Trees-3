#// Time Complexity : O(n) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def helper(t1,t2):
            if t1 == None and t2 == None:
                return True
            if t1 == None or t2 == None:
                return False
            if t1.val != t2.val:
                return False
            
            a = helper(t1.right,t2.left)
            b = helper(t1.left,t2.right)

            if a and b :
                return True
            else:
                return False
        
        return helper(root,root)
    
# Approach:
# we are checking the left child of the leftsubtree and comaring it with the right child of the right subtree 
# if they are equal then we continue else we return False 