# Time Complexity : O(n) where n is the number oof nodes on one side of tree
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :No
# Any problem you faced while coding this : Help Needed. by running this program, it is showing me the wrong answer and
# am unable to rectify the erroe



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root):
        def helper(root1, root2):

            if root1 is None and root2 is None:
                return True
            if root1 is None or root2 is None:
                return False
            else:
                return (root1.val == root2.val) and helper(root1.right, root2.left) and helper(root1.left, root2.right)

        helper(root, root)

