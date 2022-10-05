#symmetric Tree
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        else:
            return self.isMirror(root.left,root.right)
    def isMirror(self,left,right):
        if left is None and right is None:
            return True
        if left is None or right is None:
            return False
        if left.val==right.val:
            outpair = self.isMirror(left.left,right.right)
            inpair = self.isMirror(left.right,right.left)
            return outpair and inpair
        else:
            return False