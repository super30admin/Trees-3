"""
// Time Complexity : O(d) //depth of tree
// Space Complexity : O(d)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
We essentially check the tree is mirror of itself by passing two root
in the function and following conditions should be true
1) root1.left and root2.right -> all root values should be same
2) root1.right and root2.left -> all root values should be same
3) Handling null nodes
- True if both the root is null
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def isMirror(self,node1,node2):
        if not node1 and not node2:
            return True
        if not node1 or not node2:
            return False
        return node1.val == node2.val and self.isMirror(node1.left,node2.right) and self.isMirror(node2.left,node1.right)
    
    def isSymmetric(self,root):
        if root:
            return self.isMirror(root.left,root.right)
        return True