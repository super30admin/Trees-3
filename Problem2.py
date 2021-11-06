# Leetcode 101: Symmetric Tree
# Time O(n)
# Space O(n)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if root is None:
            
            return
        
        def checkSymmetry(t1, t2):
            
            if t1 == None or t2 == None:
                
                return t1 == t2
            
            if t1.val != t2.val:
                
                return False
            
            return checkSymmetry(t1.left, t2.right) and checkSymmetry(t1.right, t2.left)
        
        return checkSymmetry(root.left, root.right)