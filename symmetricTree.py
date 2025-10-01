"""
Recursively check if left and right subtrees are mirror images.
If any mismatch is found, set the flag to false.
The flag stops further recursion once asymmetry is detected.

"""
#Time Complexity: O(N)
#Space Complexity: O(N)

class Solution:
    def isSymmetric(self, root):
        self.flag = True
        if root is None:
            return True
        self.helper(root.left, root.right)
        return self.flag

    def helper(self, left, right):
        if left is None and right is None:
            return
        if left is None or right is None:
            self.flag = False
            return
        if left.val != right.val:
            self.flag = False

        if self.flag:
            self.helper(left.left, right.right)
        if self.flag:
            self.helper(left.right, right.left)