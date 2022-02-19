# // Time Complexity : O(n)
# // Space Complexity : O(n )
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : Followed approach from class
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root,root)
    
    def isMirror(self, t1:TreeNode, t2:TreeNode):
        if t1 is None and t2 is None:
            return True
        elif t1 is None or t2 is None:
            return False
        return (t1.val == t2.val) and self.isMirror(t1.right, t2.left) and self.isMirror(t1.left, t2.right)
        