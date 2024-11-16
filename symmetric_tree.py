# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Approach:
# The problem checks if the tree is a mirror of itself. For a tree to be symmetric, its left and right subtrees must be mirror images.
# This can be solved recursively by comparing the left subtree of one node with the right subtree of its counterpart and vice versa.
# Alternatively, we can solve it iteratively using a queue to perform level-order traversal and check symmetry.

# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h) for recursion (recursive approach), or O(n) for the queue (iterative approach).
# Did this code successfully run on Leetcode: Yes.
# Any problem you faced while coding this: No.

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Helper function for recursive approach
        def isMirror(t1, t2):
            if not t1 and not t2:  # Both nodes are null, they are symmetric
                return True
            if not t1 or not t2:  # One of the nodes is null, they are not symmetric
                return False
            # Check if the current nodes' values are equal and recursively check their children
            return (t1.val == t2.val) and isMirror(t1.left, t2.right) and isMirror(t1.right, t2.left)
        
        # Call the helper function to compare the left and right subtrees
        return isMirror(root.left, root.right) if root else True

    # Iterative approach
    def isSymmetricIterative(self, root: Optional[TreeNode]) -> bool:
        if not root:  # An empty tree is symmetric
            return True

        # Initialize a queue to store pairs of nodes to compare
        queue = [(root.left, root.right)]
        while queue:
            t1, t2 = queue.pop(0)
            if not t1 and not t2:  # Both nodes are null, continue to the next pair
                continue
            if not t1 or not t2 or t1.val != t2.val:  # One of the nodes is null or values are not equal
                return False
            # Add child nodes in opposite order to the queue for comparison
            queue.append((t1.left, t2.right))
            queue.append((t1.right, t2.left))
        
        return True
