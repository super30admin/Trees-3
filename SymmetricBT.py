# time: O(n)
# space : O(h)
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isSym(root, root)

    def isSym(self, tn1, tn2):

        # base cond
        if tn1 is None and tn2 is None:
            return True
        if tn1 is None or tn2 is None:
            return False

        # logic
        return (tn1.val == tn2.val) \
               and (self.isSym(tn1.right, tn2.left)) \
               and (self.isSym(tn1.left, tn2.right))
