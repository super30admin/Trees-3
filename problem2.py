# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


# Recursive approach
class Solution:
    def helper(self, left, right):
        #Base condition checks
        if left == None and right!=None:
            return False
        if left!=None and right==None:
            return False
        if left == None and right == None:
            return True
        
        # If left and right values are equal 
        # Then we traverse the left and right subtrees of left and right nodes recursively
        if left.val == right.val:
            return self.helper(left.left,right.right) and self.helper(left.right,right.left)
        
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root == None or (root.left==None and root.right == None):
            return True
        # Check if the left and right subtrees are symmetric recursively
        return self.helper(root.left,root.right)
        
        
        
        
        