#Time - O(n)
#Space - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag=True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.dfs(root.left,root.right)
        return self.flag
    
    def dfs(self,left,right):
        #base
        if(left==None and right==None):
            return True

        if left==None or right==None or left.val!=right.val:
            self.flag=False
            return self.flag



        #logic
        self.dfs(left.left,right.right)
        self.dfs(left.right,right.left)