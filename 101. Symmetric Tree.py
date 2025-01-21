#Time: O(n)
#Space: O(height of recursive stack)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        self.balanced = True
        self.dfs(root.left, root.right)
        return self.balanced

    def dfs(self,left,right):
        if ( left == None and right == None):
            return 
        if(left == None or right == None):
            self.balanced = False
            return 
        if( left.val != right.val):
            self.balanced = False
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)
        return




        
