# Time Complexity: O(n)
# Space Complexity: O(h)-> height of the tree
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return
        
        def helper(t1, t2):
            if not t1 and not t2:
                return True
            
            if (t1 and not t2) or (t2 and not t1):
                return False
            
            if t1.val!=t2.val:
                return False

            return helper(t1.left, t2.right) and helper(t1.right, t2.left)
            
        return helper(root.left, root.right)         