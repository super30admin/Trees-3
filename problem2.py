# Time Complexity : O(n)
# Space Complexity : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.ismirror(root.left,root.right)
    
    def ismirror(self,actual,mirror):
        if actual == None and mirror == None:
            return True
        
        if actual == None or mirror == None or actual.val != mirror.val:
            return False
        
        return self.ismirror(actual.left,mirror.right) and self.ismirror(actual.right,mirror.left)