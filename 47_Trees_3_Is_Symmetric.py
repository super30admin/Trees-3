#Time Complexity : O(n) where n is the number of elements
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        def helper(left,right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            return left.val==right.val and helper(left.left,right.right) and helper(left.right,right.left)
        if not root:
            return True
        return helper(root.left,root.right)
        
        