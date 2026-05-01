# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n) where n is the number of nodes in the tree
# Space Complexity --> O(log n)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root.left, root.right)

    def helper(self, n1, n2):
        # base
        if n1 is None and n2 is None:
            return True
        if (n1 is None and n2 is not None) or (n1 is not None and n2 is None):
            return False
        if n1.val!=n2.val:
            return False
        # logic
        case1 = self.helper(n1.left, n2.right)
        case2 = self.helper(n1.right, n2.left)
        return case1 and case2 
