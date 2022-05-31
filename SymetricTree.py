'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(left,right):
            if left==None and right==None: return True
            if(left==None or right==None or left.val != right.val):return False
            if(dfs(left.right,right.left) == False): return False
            return dfs(left.left,right.right)
        return dfs(root.left,root.right)