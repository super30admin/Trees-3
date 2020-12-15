# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#O(N)
#O(N)
#check for both trees conditions only if Left and Right values are equal
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def isSym(L,R):
            if not L and not R: return True
            if not L or not R or L.val != R.val: return False
            return isSym(L.left, R.right) and isSym(L.right, R.left)
        if root is None:
            return True
        return isSym(root.left, root.right)