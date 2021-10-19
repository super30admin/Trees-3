#TC = O(nlogn)
#SC = O(n)
#Compiled and run on LC

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True

        return self.isMirror(root.left, root.right)

    def isMirror(self, leftchild, rightchild):

        if leftchild and rightchild:
            return ((leftchild.val == rightchild.val) and
                    self.isMirror(leftchild.left, rightchild.right) and self.isMirror(leftchild.right, rightchild.left))

        return leftchild == rightchild
