# Time Complexity : O(n) [n = number of nodes in tree]
# Space Complexity : O(h) [h = height of tree]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Compare the value of the left child and right child
# 2. Make Recusive call for comapring the following - 
#   2.1 left of left child and right of right child 
#   2.2 left of right child and right of left child
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None or (root.left is None and root.right is None):
            return True
        
        if not root.left or not root.right:
            return False
        
        def helper(left, right):
            ## base
            if not left and not right:
                return True
            
            if not left and right:
                return False
            if  left and  not right:
                return False
        
            ## body
            if left.val == right.val and helper(left.left, right.right) and helper(left.right, right.left):
                return True
        return helper(root.left, root.right)