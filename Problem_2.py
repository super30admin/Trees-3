"""
Time Complexity : O(n) , technically O(n/2) as we are traversing 2 nodes at a time
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, from root node, we go left and right simultaneously. If every left equals right and every 
right equals left,it is symmetric

"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    def isSymmetric(self, root):
        if not root:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val == right.val:
            return self.helper(left.left, right.right) and self.helper(left.right, right.left)
