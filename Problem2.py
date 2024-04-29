## Problem2 (https://leetcode.com/problems/symmetric-tree/)

# Approach
# There are 3 conditions to be checked in symmetric tree problem 1) if both sides nodes are None, return True. 2) If only 1 is None, return False and 3) If t1.val != t2.val, return Fals
# Call helper function with root node. Recursively call t1.right with t2.left. Similarly call t1.left with t2.right. Check for the above 3 condition
# return the result of 2 recusive calls using and operator where it will return True only if all nodes are mirror and tree is symmetric or it will return False

# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def helper(self,t1,t2):
        if t1 is None and t2 is None:
            return True
        if t1 is None or t2 is None:
            return False
        if t1.val != t2.val:
            return False                                        

        return (
        self.helper(t1.right,t2.left) and self.helper(t1.left,t2.right))
        

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root,root)