# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree (O(n) in worst case)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def isSymmetric(self, root):
        if not root:
            return True
        def isMirror(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            return isMirror(left.left, right.right) and \
                   isMirror(left.right, right.left) 
        return isMirror(root.left, root.right)
