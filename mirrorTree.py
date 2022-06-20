"""Approach:

Start helper call with two root values, exactly same root. Then 
if either t1 or t2 is None return False => As tree is unbalanced
if both t1 and t2 are none then return true => as both nodes are pointing to None, both just passed the leaf nodes and reached end of that path.

TC : O(n). Because we traverse the entire input tree once,where n is the total number of nodes in the tree.

SC : O(n)  # recursive calls is bound by the height of the tree. For worst case, the tree is skewed in one side and the height is in O(n). Hence stack space used is O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root,root)

    def isMirror(self, t1, t2) -> bool:
        if t1 is None and t2 is None: return True
        if t1 is None or t2 is None: return False
        return (t1.val == t2.val) and self.isMirror(t1.right, t2.left) and self.isMirror(t1.left, t2.right)

