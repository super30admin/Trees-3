#Time complexity: O(n)
#Space complexity: O(1)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root) -> bool:
        if root== None:
            return True
        return self.check(root.left,root.right)
    def check(self,left_sub,right_sub):
        if not left_sub and not right_sub:
            return True
        elif left_sub and right_sub:
            return (left_sub.val==right_sub.val) and (self.check(left_sub.left,right_sub.right)) and (self.check(left_sub.right,right_sub.left))
        else:
            return False
        