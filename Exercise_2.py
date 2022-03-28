# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def checkMirror(tLeft, tRight):
            if not tLeft and not tRight:
                return True
            if not tLeft or not tRight:
                return False
            return checkMirror(tLeft.right, tRight.left) and checkMirror(tLeft.left, tRight.right) and (tLeft.val == tRight.val)

        return checkMirror(root, root)