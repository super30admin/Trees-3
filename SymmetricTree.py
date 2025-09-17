# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(h) where h is the recursion stack space maximum height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a recursive approach to check if the tree is symmetric.
# I define a helper function 'check' that takes two nodes as input and checks if they are mirror images of each other.
# The function checks if both nodes are None (base case), if one of them is None, or if their values are not equal.
# If the values are equal, it recursively checks the left subtree of one node with the right subtree of the other node and vice versa.
# Finally, I call the 'check' function with the left and right children of the root node.

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def check(left,right):
            if not left and not right:
                return True
            if not left or not right or left.val != right.val:
                return False
            return (left.val == right.val and check(left.left,right.right) and check(left.right,right.left))
        return check(root.left,root.right)

        