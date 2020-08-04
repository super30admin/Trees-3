# Time Complexity : O(d) depth of the tree
# Space Complexity : O(d) recursive stack storage
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#we recursively iterate each node checking its value, equals and its child values of oppsoite direction are equal.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def isSymmetric(self, root: TreeNode) -> bool:

        return self.helper(root, root)

    def helper(self, node1, node2):

        if node1 is None and node2 is None:
            return True
        if node1 is None or node2 is None or node1.val != node2.val:
            return False

        return self.helper(node1.left, node2.right) and self.helper(node1.right, node2.left)
