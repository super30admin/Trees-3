# Time Complexity : O(n)
# Space Complexity : O(k) k:height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __helper(self, n1, n2):
        if n1 is None and n2 is None:
            return True
        elif n1 is None or n2 is None:
            return False
        return (n1.val==n2.val) and self.__helper(n1.left, n2.right) and self.__helper(n1.right, n2.left)
    
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.__helper(root, root)