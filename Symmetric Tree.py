# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self,left:TreeNode,right:TreeNode) -> list:
        if(left==None and right==None):return True
        if(left==None or right==None or left.val!=right.val):
            return False
        case1=self.dfs(left.left,right.right)
        case2=self.dfs(left.right,right.left)
        return case1 and case2
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if(root==None):return True
        return self.dfs(root.left,root.right)
