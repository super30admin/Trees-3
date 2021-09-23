# Time Complexity : O(N) as we go over all N nodes
# Space Complexity : O(N) for recursion stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Major issues with global variables
# Your code here along with comments explaining your approach

# simultaneously check left.left and left.right and left.right and right.left 
# to determine if symmetric or not


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root):

        if root is None:
            return True
        return self.dfs(root.left, root.right)

    def dfs(self, left, right):

        if left is None and right is None:
            return True
        if left is None or right is None or left.val != right.val:
            return False
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)