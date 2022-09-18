# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def compare(tree1,tree2):
            if(tree1==None and tree2==None):
                return True
            if((not tree1 and tree2)or(tree1 and not tree2)or(tree1.val!=tree2.val)):
                return False
            return compare(tree1.left,tree2.right) and compare(tree1.right,tree2.left)
        return compare(root.left,root.right)