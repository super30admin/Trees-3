# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# We want to compare the left sub-tree and the right sub-tree of the root at the same time.
# We want to compare the left child of root to the right child of the root to identify whether the tree is a mirror of itself.
# We recursively check the children of the root node.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root) -> bool:
        def same(root1, root2):
            # if both the roots are null, we have reached a base case and we return True
            if not root1 and not root2:
                return True
            # If at some time one of the root is not null, it means that the tree is not mirrored, and we return False
            if not root1 or not root2:
                return False
            # If at some point, a the value of both the roots don't match with each other, it would also mean that the tree is not mirrored and we need to return False
            if root1.val != root2.val:
                return False
            
            # We need to compare root1's left to root2's right and root1's right to root2's left
            return same(root1.left, root2.right) and same(root1.right, root2.left)

        # Return the result of the recursive function
        return same(root, root)