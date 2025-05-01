# 101. Symmetric Tree

# TC: O(N) where N is the number of nodes in the tree
# SC: O(H) where H is the height of the tree (recursion stack)
# Did this code successfully run on Leetcode: Yes

# Approach:
# We check if the tree is empty - an empty tree is symmetric
# Otherwise, we use a helper function isMirror to check if two subtrees are mirrors of each other
# Two subtrees are mirrors if:
    # Both are empty (both None) - base case
    # Both root nodes have the same value
    # The left subtree of the first tree is a mirror of the right subtree of the second tree
    # The right subtree of the first tree is a mirror of the left subtree of the second tree
# We start by comparing the left and right subtrees of the root


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import List, Optional


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # TC: O(N) where N is the number of nodes in the tree
        # SC: O(H) where H is the height of the tree (recursion stack)
        # Did this code successfully run on Leetcode: Yes
        
        # Base case: empty tree is symmetric
        if not root:
            return True
        
        # Use helper function to check if left and right subtrees are mirrors
        return self.isMirror(root.left, root.right)
    
    def isMirror(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        # If both nodes are None, they are symmetric
        if not left and not right:
            return True
        
        # If only one node is None, they are not symmetric
        if not left or not right:
            return False
        
        # For nodes to be mirrors:
        # 1. Their values must be equal
        # 2. Left's left must be mirror of Right's right
        # 3. Left's right must be mirror of Right's left
        return (left.val == right.val and
                self.isMirror(left.left, right.right) and
                self.isMirror(left.right, right.left))