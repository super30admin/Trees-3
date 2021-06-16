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
# Space            :  14.4 MB (26.52 %ile)

# Logic: Take two copies of root and recursively call in reversed order to
#        mirror the tree. Then check if mirror elements are equal at each
#        recursive call

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isSymmetricHelper(root, root)
        
        
    
    def isSymmetricHelper(self, node1: TreeNode, node2:TreeNode) -> bool:
        # If both elements are none its okay
        if node1 is None and node2 is None:
            return True
        # If one of the mirror elements is none and other is not,
        # then tree is not symmetric
        elif node1 is None or node2 is None:
            return False
        else:
            # Mirror elements have to be equal
            return ((node1.val == node2.val) and \
            # Left child of element should be equal to right child of
            # mirror element -> defnition of mirror.
            self.isSymmetricHelper(node1.left, node2.right) and \
            # And vice versa.
            self.isSymmetricHelper(node1.right, node2.left))