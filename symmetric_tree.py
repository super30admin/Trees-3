# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.symm(root, root)
        
    def symm(self, node1, node2):
        if (node1 and not node2) or (node2 and not node1):
            return False
        if not node1 and not node2:
            return True
        return (node1.val == node2.val) and self.symm(node1.left, node2.right) and self.symm(node1.right, node2.left)