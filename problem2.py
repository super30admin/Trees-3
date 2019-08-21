"""
Time: O(n)
Space: O(n) <On recursive stack>
Leet: Accepted
Problems: None
"""

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def helper(left,right):
            if left is None and right is None:
                return True
            if left is None or right is None or left.val != right.val:
                return False

            return helper(left.left,right.right) and helper(left.right,right.left)

        if not root:
            return True

        return helper(root.left,root.right)
