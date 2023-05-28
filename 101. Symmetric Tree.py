#Time Complexity:O(n)
#Space Complexity:O(h-height of the tree)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root ==None:
            return True
        self.valid=True
        self.dfs(root.left,root.right)
        return self.valid
        
    def dfs(self,rootA,rootB):
        if rootA==None and rootB==None:
            return
        if rootA==None or rootB==None:
            self.valid=False
            return
        if rootA.val!=rootB.val:
            self.valid=False
            return
        self.dfs(rootA.left,rootB.right)
        self.dfs(rootA.right,rootB.left)
        return
