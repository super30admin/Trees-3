# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
           return True
        
        def isMirror(a: Optional[TreeNode], b: Optional[TreeNode]) -> bool:

            if a is None and b is None:
                return True
            
            if a is None or b is None:
                return False

            return (a.val == b.val 
                and isMirror(a.left, b.right)
                and isMirror(a.right, b.left)
            )

        return isMirror(root.left, root.right)
        
#  Problem: Symmetric Tree (LeetCode 101)
#  Approach (Recursive: mirror check on pairs a,b)
#  Time Complexity : O(N)
#    We visit each node at most once while comparing mirrored pairs.
#  Space Complexity : O(H) for recursion stack (H = tree height; worst-case O(N) for a skewed tree).
#  Did this code successfully run on LeetCode : Yes (101).
#  Any problem you faced while coding this :
#    - Forgetting that both None is symmetric, but one None and one node is not.
#    - Not swapping sides correctly: must compare a.left with b.right AND a.right with b.left.
#    - Accessing .val before None checks (order of checks matters).