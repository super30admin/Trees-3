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
        if root is None: # If root is empty then return
            return
        return self.dfs(root.left, root.right) # Recursive Function to check symmetry
        #return self.symmetry
    
    def dfs(self, left, right):
        if left is None and right is None: # if both are null that is end of tree
            return True
        if left is None or right is None: # if either left or right is none and other is not None 
            #symmetry = False
            return  False       
        if left.val!=right.val: # If both are not empty but have different values
            #self.symmetry = False
            return False
        case1 = self.dfs(left.left, right.right) #calling left modt side
        case2 = self.dfs(left.right, right.left) # calling inner nodes
        return case1 and case2
        

        
