# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root==None:
            return True
        #basic way is to be too
        def findSym(node1,node2):
            if node1 and node2:
                if node1.val==node2.val:
                    return findSym(node1.left,node2.right) and findSym(node1.right,node2.left)
                else:
                    return False
            if node1==None and node2==None:
                return True
            return False
        return findSym(root.left,root.right)
       #Time O(n)
       #Space O(n)
        
