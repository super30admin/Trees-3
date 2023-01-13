#time O(N)
#space O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def helper(t1,t2):
            if t1==None and t2==None:
                return True
            if t1==None or t2==None:
                return False
            return (t1.val==t2.val)and helper(t1.left,t2.right) and helper(t1.right,t2.left)
        return helper(root,root)