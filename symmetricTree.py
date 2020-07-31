# Leetcode 101. Symmetric Tree

# Time Complexity :  O(n) where n is the number of the nodes in the tree

# Space Complexity : O(h) where h is the height of the tree

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: To check for symmetry of a tree, check if the extremes of a sub tree i.e. left child of
# left subtree and right child of right subtree are same. And if middle elements i.e. right child of
# left subtree and left child of right subtree are same. If the condition is not satisfied at any node
# then the tree is not symmetric. If the entire tree can be recurrsively verified for this condition then
# the tree is symmetric.

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # BASE
        if root == None:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        # Leaf Node
        if left == None and right == None:
            return True
        # Un symmetric
        if left == None or right == None or left.val != right.val:
            return False
        # recurssive call for left and right extremes and
        # recurssive call for left and right middle elements to check for symmetry
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
