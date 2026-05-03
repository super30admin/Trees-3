# O(n) time bc we visit every node
# O(h) space bc max depth of recursion stack

# compare the left child of each node to the right child on the other side of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True 
        return self.ismirror(root.left,root.right)

    def ismirror(self, leftroot, rightroot):
        if leftroot and rightroot:
            return leftroot.val == rightroot.val and self.ismirror(leftroot.left, rightroot.right) and self.ismirror(leftroot.right,rightroot.left)
        return leftroot == rightroot