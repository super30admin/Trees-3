#Time Complexity : O(n) time
#Space Complexity : O(h) space - height of the tree
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(left, right):
            if left is None and right is None:
                return True
            if left is None and right is not None:
                return False
            if left is not None and right is None:
                return False
            if left.val != right.val:
                return False
            
            return helper(left.left, right.right) and helper(left.right, right.left)
        
        if root is None:
            return True
        else:
            return helper(root.left, root.right)

