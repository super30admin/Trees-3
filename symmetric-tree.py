'''
Time complexity: O(N)
Space complexity: O(H)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isSym = True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.dfs(root,root)
        if self.isSym == True:
            return True
        return False

    
    def dfs(self,left,right):
        if left is None and right is None:
            return 
        if left is None or right is None:
            self.isSym = False
            return 
        if left.val != right.val:
            print('yes')
            self.isSym = False
            return
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)


        
        