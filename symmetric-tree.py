# Time: O(n)
# Space: O(n)
class Solution:
    def __init__(self):
        self.resultR = []
        self.resultL = []

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.preorder(root.left, False)
        self.preorder(root.right, True)

        if self.resultR == self.resultL:
            return True
        return False
    
    def preorder(self, root, flag):
        if root == None:
            if flag: self.resultL.append(-200)
            else: self.resultR.append(-200)
            return

        if flag:
            self.resultL.append(root.val)
            self.preorder(root.left, flag)
            self.preorder(root.right, flag)
        else:
            self.resultR.append(root.val)
            self.preorder(root.right, flag)
            self.preorder(root.left, flag)

# Another approach checking left.left == right.right and left.right == right.left in recursion
# without using extra space 
        