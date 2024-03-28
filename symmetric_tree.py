# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from collections import Optional, TreeNode
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root==None:
            return True

        def dfs(left,right):
            if left==None and right==None:
                return True

            if (left!=None and right==None) or (left==None and right!=None):
                return False

            if left.val!=right.val:    
                return False

            return dfs(left.left,right.right) and dfs(left.right,right.left)

        return dfs(root.left, root.right)