#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : yes
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        return self.helper(root.left,root.right)

    #Checking the left and right of left child with right and left child of right subtree
    def helper(self,l,r):
        
        if not l and not r:
            return True
        if not l or not r:
            return l==r 
        if l.val!=r.val:
            return False
        
        return self.helper(l.left,r.right) and self.helper(l.right,r.left)