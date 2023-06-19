"""
Problem : 2

Time Complexity : O(n) 
Space Complexity : O(h) //h=height of the tree

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Calling out the recursion function to traverse and check the values of
left node of left subtree with right node of right subtree and right node of left subtree and left node of roght subtree
if both the nodes are none means we have encountered the end, but still symmetric tree, but if one of the given node is present, means the violation of symmetry

"""

# Symmetric Tree

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
        return self.helper(root.left,root.right)
    def helper(self,left,right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        return (left.val==right.val and self.helper(left.left,right.right) and self.helper(left.right,right.left))
        
        