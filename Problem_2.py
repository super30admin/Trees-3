
# 101. Symmetric Tree


# Code: 

# Approach: Recursive twice with the root, In one check L-R and the other will check R-L.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        return self.helper(root, root)
    
    def helper(self, p,q):
        if not p and not q:
            return True
        if not p or not q:
            return False
        
        return p.val==q.val and self.helper(p.left, q.right ) and self.helper(p.right, q.left)


# Time complexity: O(N) 
# Space complexity: O(1)
# Accepted on Leetcode: Yes.
