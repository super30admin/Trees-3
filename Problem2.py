## Problem2 (https://leetcode.com/problems/symmetric-tree/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        """
        Time Complexity: O(N)
        - N is the total number of nodes in the tree. In the worst case, 
          we have to visit every single node to verify symmetry.
          
        Space Complexity: O(N)
        - The space complexity is determined by the height of the recursion stack.
        - In the worst case (a highly unbalanced tree), the recursion depth can 
          reach O(N). For a completely balanced tree, it would be O(log N).
        """
        
        def helper(lRoot, rRoot):
            # Base Case 1: If both nodes are null, this branch is symmetric.
            if lRoot is None and rRoot is None:
                return True
            
            # Base Case 2: If only one node is null (since we passed Base Case 1), 
            # there is a structural mismatch, meaning it's not symmetric.
            if not lRoot or not rRoot:
                return False
            
            # Recursive Step: For two trees to be mirror images of each other:
            # 1. Their root node values must be equal.
            # 2. The left subtree of the left tree must be a mirror of the right subtree of the right tree.
            # 3. The right subtree of the left tree must be a mirror of the left subtree of the right tree.
            return (lRoot.val == rRoot.val and 
                    helper(lRoot.left, rRoot.right) and 
                    helper(lRoot.right, rRoot.left))
        
        # We start the check by comparing the left and right subtrees of the main root.
        # (Assumes the root is not None, which is typical based on LeetCode constraints >= 1 node).
        return helper(root.left, root.right)