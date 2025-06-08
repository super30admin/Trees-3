# S30 Problem #48 Symmetric Tree
#LeetCode #101 https://leetcode.com/problems/symmetric-tree/description/

# Author : Akaash Trivedi
# Time Complexity : O(h) -> height of the tree
# Space Complexity : O(1) or h for the height of recursive stack 
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No


# Consider them as two separate subproblems
# tree left (tl) and tree right (tr)
# Recursively check the symmetry, with values at each call
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, root)
    
    def helper(self,tl,tr)-> bool:
        # base
        if tl is None and tr is None:
            return True
        # if only one is None and other isnt then it not symmetric
        if tl is None or tr is None:
            return False
        # logic
        if tl.val == tr.val:
            left = self.helper(tl.left,tr.right)
            right = self.helper(tl.right,tr.left)
            return left and right
        else:
            return False
