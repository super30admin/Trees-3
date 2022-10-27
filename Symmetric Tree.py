# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # leetcode URL : https://leetcode.com/problems/symmetric-tree/
    # Problem : 101. Symmetric Tree
    # Time Complexity : O(n)
    # Space Complexity : O(n)
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isSymmetric2( root.left,root.right)
# Iterative solution below:
#         stack = list()
#         stack.append((root.left,root.right))
        
#         while len(stack)!=0:
#             top = stack.pop()
            
#             if top[0] == None and top[1] == None:
#                 continue
#             elif top[0] == None or top[1] == None:
#                 return False
            
#             if top[0].val != top[1].val:
#                 return False
#             else:
#                 stack.append((top[0].left,top[1].right))
#                 stack.append((top[1].left,top[0].right))
#         return True
    
    def isSymmetric2(self, left_side,right_side):
        if (left_side == None and right_side==None):
            return True
        if (left_side == None or right_side==None) or (left_side.val != right_side.val):
            return False
        
        return self.isSymmetric2( left_side.left,right_side.right) and self.isSymmetric2( left_side.right,right_side.left)
        
        
        
        