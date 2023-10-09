# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n) where n is the number of elements in the tree
# Space Complexity: O(h) where h is the height of the tree
class Solution(object):
    def isSymmetric(self, root):
        self.symmetry = True # gloabl varibale set to True
        if root is None: # If root is empty then return
            return
        
        self.dfs(root.left, root.right) # Recursive Function to check symmetry
        return self.symmetry
    
    def dfs(self, left, right):
        if left is None and right is None: # if both are null that is end of tree
            return
        if left is None or right is None: # if either left or right is none and other is not None 
            self.symmetry = False
            return        
        if left.val!=right.val: # If both are not empty but have different values
            self.symmetry = False
        self.dfs(left.left, right.right) #calling left modt side
        self.dfs(left.right, right.left) # calling inner nodes
        

        
