# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # calling the heler function on root.left and root.right subtree
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root.left, root.right)
        
    def isMirror(self, left_tree, right_tree):
        # checking if we have reached null, which is the end of the tree
        if not left_tree and not right_tree:
            return True
        # if either of the nodes is not null, then tree is not symmetric
        if not left_tree or not right_tree:
            return False
        # we compare the values of both the nodes then recursively call the function on left and right subtree but with opposite nodes
        # as we are looking for a mirror image
        return left_tree.val == right_tree.val and self.isMirror(left_tree.left, right_tree.right) and self.isMirror(left_tree.right, right_tree.left)
