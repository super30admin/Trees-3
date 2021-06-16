'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 101. Symmetric Tree
# Given the root of a binary tree, check whether it is a mirror of 
# itself (i.e., symmetric around its center).

#-----------------
# Time Complexity: 
#-----------------
# O(N): Where N is the number of elements in the tree. Need to visit every element
#       at least twice -> So 2N complexity.

#------------------
# Space Complexity: 
#------------------
# O(N): Need two arrays of size N to return boolean. 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :  32 ms   (82.07 %ile)
# Space            :  14.2 MB (81.92 %ile)

# Logic: Just reverse the order of left and right in 2 inorder traversals.
#        The resultant traversals have to be equal. Then tree is symmetric.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.inorderLeft(root, []) == self.inorderRight(root, [])
        
        
    
    def inorderLeft(self, root: TreeNode, result:List[int]) -> None:
        if root is None:
            # print("none", end=",")
            result.append(None)
        else:
            # print(root.val, end=",")
            result.append(root.val)
            self.inorderLeft(root.left, result)
            self.inorderLeft(root.right, result)
        return result
    
    def inorderRight(self, root: TreeNode, result:List[int]) -> None:
        if root is None:
            # print("none", end=",")
            result.append(None)
        else:
            # print(root.val, end=",")
            result.append(root.val)
            self.inorderRight(root.right, result)
            self.inorderRight(root.left, result)
        
        return result