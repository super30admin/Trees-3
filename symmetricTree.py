# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkMirror(self,t1,t2):
        if t1 == None and t2 == None:
            return True
        if t1 == None or t2 == None:
            return False
        return (t1.val == t2.val) and self.checkMirror(t1.right,t2.left) and self.checkMirror(t1.left,t2.right)
    
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.checkMirror(root,root)
