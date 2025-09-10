"""
TC: O(N) {we traverse each node once to check symmetry}
SC: O(H) {recursive stack depth, where H is the height of the tree}

Approach:

We use void-based recursion with a class variable to store the symmetry status.
At each recursive call, we compare two nodes (left and right).
If both are None, we return as they are symmetric.
If only one is None or their values differ, we mark the tree as not symmetric.
Otherwise, we continue checking recursively:
- left.left with right.right
- left.right with right.left
If all checks pass, the tree is symmetric.

The problem ran successfully on LeetCode.
"""

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def helper(self, left, right):
        if not left and not right:
            return
            
        if (not left and right) or (left and not right) or (left.val != right.val):
            self.symmetric = False
            return
        

        self.helper(left.left, right.right)
        self.helper(left.right, right.left)


    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.symmetric = True
        self.helper(root.left, root.right)
        return self.symmetric