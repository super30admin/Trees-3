# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree

# Your code here along with comments explaining your approach 
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if(root==None):
            return True
        return self.dfs(root.left,root.right)
    def dfs(self, left, right):
        if(left==None and right==None):
            return True
        if(left==None or right==None):
            return False
        leftMirror = self.dfs(left.left,right.right)
        rightMirror = self.dfs(left.right,right.left)
        return(leftMirror and rightMirror)