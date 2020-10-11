# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        def helper(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            return helper(left.left, right.right) and helper(left.right , right.left)
        
        return helper(root, root)
