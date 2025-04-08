# Time Complexity: O(n)
# Space Complexity: O(n) when the tree is skewed
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return root is None or self.checkIsSymmetric(root.left, root.right)
    def checkIsSymmetric(self, left, right)-> bool:
        if left is None or right is None:
            return left == right
        if left.val != right.val:
            return False
        return (self.checkIsSymmetric(left.left, right.right) and 
               self.checkIsSymmetric(left.right, right.left))