# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
        
        return self.dfs(root.left, root.right)
    
    def dfs(self, left, right):
        if left == None and right == None:
            return True
        if left == None or right == None or left.val != right.val:
            return False
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)
        
#T.C => O(h)
#S.C => O(n) => satck base since we use stack in recursion
#Approach => here we check the root.left and root.right and also left.left, right.right along with left.right and right.left if both of these are similar we go on to check till leaf. 
#These return false and true based on the condition 