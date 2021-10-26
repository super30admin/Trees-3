#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.sym(root.left, root.right)
        
    def sym (self, leftroot, rightroot):
            if leftroot and rightroot:
                return leftroot.val == rightroot.val and self.sym(leftroot.left, rightroot.right) and                             self.sym(leftroot.right, rightroot.left)
            return leftroot == rightroot
        
         
