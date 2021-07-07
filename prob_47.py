#ran in leetcode
#space - O(1) if we omit the input, not taking any extra space
#time -  O(n)


class Solution:
    def isSymmetric(self, root):
        return self.ismirror(root, root)

    def ismirror(self, root1, root2):
        if not (root1) and not (root2):
            return True
        if root1 and root2:
            if root1.val == root2.val:
                return (self.ismirror(root1.left, root2.right) and self.ismirror(root1.right, root2.left))
