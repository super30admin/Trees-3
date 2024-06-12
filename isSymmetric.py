# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity:O(n)
#Space Complexity:O(log n)
# Ran successfully on Leetcode:Yes
#Here also I am creating a stack where I store the values of the root I m operating on. Then I check if the current root's right matches root's left and other way rouund. 

#Iterative Solution:

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if  root is None :
            return True 
        
        stack=[[root.left,root.right]]
        
        while(len(stack)>0):
            pair=stack.pop(0)
            left=pair[0]
            right=pair[1]
            if left is None and right is None:
                continue
            if left is None or right is None:
                return False
            if left.val==right.val:
                stack.insert(0,[left.left,right.right])
                stack.insert(0,[left.right,right.left])
            else:
                return False
        return True
 #Recursive solution:             
  def isSymmetric(self, root):
    if root is None:
      return True
    else:
      return self.isMirror(root.left, root.right)

  def isMirror(self, left, right):
    if left is None and right is None:
      return True
    if left is None or right is None:
      return False

    if left.val == right.val:
      outPair = self.isMirror(left.left, right.right)
      inPiar = self.isMirror(left.right, right.left)
      return outPair and inPiar
    else:
      return False
                
                
#         while len(stack) > 0:
#               pair = stack.pop(0)
#               left = pair[0]
#               right = pair[1]

#               if left is None and right is None:
#                 continue
#               if left is None or right is None:
#                 return False
#               if left.val == right.val:
#                 stack.insert(0, [left.left, right.right])

#                 stack.insert(0, [left.right, right.left])
#               else:
#                 return False
        
#     return True
