# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root,root)
    
    def isMirror(self,roota,rootb):
        if roota==None and rootb==None:
            return True
        if roota==None or rootb==None:
            return False
        
        return roota.val==rootb.val and self.isMirror(roota.left,rootb.right) and self.isMirror(rootb.left,roota.right) 