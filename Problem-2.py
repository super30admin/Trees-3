# Approach
# We are checking the left half and right half simultaneously
# if both aree nobe return true else check left.left with right.right.right and left.right with right.left


#Complexities
#Time: O(n)
#Space : O(h) h : height of the trree

# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def mirror(self, left, right):
        if left == None and right == None:
            return True
        if (left == None and right != None) or (left != None and right == None):
            return False
        return (left.val == right.val) and self.mirror(left.left, right.right) and self.mirror(left.right, right.left)

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root.left == None and root.right == None:
            return True

        return self.mirror(root.left, root.right)


