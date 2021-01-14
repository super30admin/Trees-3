# Time Complexity : O(N)
# Space Complexity : O(H) height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.checkSymmetry(root.left,root.right)
    
    
    def checkSymmetry(self, subTreeA, subTreeB):
        if subTreeA is None and subTreeB is None:
            return True
        elif subTreeA and subTreeB:
            return ((subTreeA.val == subTreeB.val) and (self.checkSymmetry(subTreeA.left,subTreeB.right) and (self.checkSymmetry(subTreeA.right, subTreeB.left))))
    
        return False