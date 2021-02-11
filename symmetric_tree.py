'''
Time complexity: O(n)
Space complexity: O(max_Depth)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.recur(root.left, root.right)
    
    def recur(self, N1, N2):
        if N1 is None and N2 is None:
            return True
        if N1 is None or N2 is None or N1.val != N2.val:
            return False
        return self.recur(N1.left, N2.right) and self.recur(N1.right, N2.left)