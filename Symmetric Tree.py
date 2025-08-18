# Time Complexity :O(N)
# Space Complexity :O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code checks whether a binary tree is symmetric (a mirror of itself). It uses a recursive dfs that compares the left subtree of one side with the right subtree of the other side (and vice versa). If all corresponding pairs of nodes match in value and structure, it returns True; otherwise, it returns False.

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.dfs(root.left, root.right)
    
    def dfs(self, left, right):
        if left is None and right is None:
            return True
        
        if left is None or right is None or left.val != right.val:
            return False
        
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)