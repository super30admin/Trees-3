#  101. Symmetric Tree
'''
Leetcode all test cases passed: Yes
Solution:
     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        n is the no of nodes in the tree
        h is the height of the tree
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isMirror(root,root)
    def isMirror(self,root1,root2):
        if root1 == None and root2 == None:
            return True
        if root1 == None or root2 == None:
            return False
        return root1.val == root2.val and self.isMirror(root1.right,root2.left) and self.isMirror(root2.right,root1.left)
