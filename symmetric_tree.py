# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isSymmetricTree(root.left,root.right)
        
    def isSymmetricTree(self, node1: TreeNode, node2: TreeNode):
        if node1 and node2:
            return node1.val == node2.val and self.isSymmetricTree(node1.left,node2.right) and self.isSymmetricTree(node1.right,node2.left)
        else:
            return node1 == node2
