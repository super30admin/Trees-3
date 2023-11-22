# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def isSymmetricHelper(self, root1, root2):
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False
        if root1.val != root2.val:
            return False
        
        return self.isSymmetricHelper(root1.left, root2.right) and self.isSymmetricHelper(root1.right, root2.left)
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isSymmetricHelper(root.left, root.right)