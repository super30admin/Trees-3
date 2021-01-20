# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        """
        Description: Given a binary tree, check whether it is a mirror of itself
        
        Time Complexicity: O(n), n = number of nodes
        Space Complexicity: O(h), h = height of the tree
        
        Approach:
        1. Check left and right nodes at each level (extreme ends)
        2. Check left of right node and right of left node at each level
        3. Recursive calls until base condition is reached where node is a leaf
        """
        if root == None: return True
        self.isValid = True
        self.helper(root.left, root.right)
        
        return self.isValid
    
    def helper(self, left, right):
        
        # Base Case
        if left == None and right == None: return
        if left == None or right == None or (left.val != right.val):
            self.isValid = False
        
        # Logic
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)
