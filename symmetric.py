
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def isSymmetric(self, root) -> bool:
        # base case
        if not root:
            return True
        return self.mirror(root.left, root.right)
    
    def mirror(self, t1, t2):
        
        # check if values are same and
        # right subtree of each tree is reflection of left subtree of each tree
        if t1 and t2:
            return t1.val == t2.val and self.mirror(t1.left, t2.right) and self.mirror(t1.right, t2.left)
        
        return t1 == t2