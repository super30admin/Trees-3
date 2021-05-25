class Solution:
    def __init__(self):
        self.ismirror = True
    def isSymmetric(self, root: TreeNode) -> bool:
        self.helper(root.left,root.right)
        return self.ismirror
    def helper(self, left: TreeNode, right: TreeNode):
        if left == None and right == None:
            return
        if left == None or right == None:
            self.ismirror = False
            return
        if left.val != right.val:
            self.ismirror = False
            return
        self.helper(left.left,right.right)
        self.helper(left.right,right.left)
