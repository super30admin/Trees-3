# Time Complexity: O(N)
# Space complexity: O(1)
# Compiled on leetcode?: Yes

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.helper(root.left, root.right)
        
    
    def helper(self, left, right):
        if left is None and right is None:
            return True
        if left is None or right is None or left.val != right.val:
            return False
        
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)