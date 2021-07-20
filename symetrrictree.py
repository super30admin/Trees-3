# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        self.result=True
        def helper(rootLeft:TreeNode,rootRight:TreeNode):
            #base
            if rootLeft==None and rootRight==None:
                return
            if rootLeft==None or rootRight==None:
                self.result=False
                return
            #logic
            if(rootLeft.val!=rootRight.val):
                self.result=False
                return
            helper(rootLeft.left,rootRight.right)
            helper(rootLeft.right,rootRight.left)
        helper(root.left,root.right)
        return self.result
        
            