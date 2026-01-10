# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def helper(left:root, right:root)->bool:
            if(left == None and right ==None):
                return True

            if(left == None or right == None):
                return False

            if(left.val!=right.val):
                return False

            return helper(left.left, right.right) and helper(left.right, right.left)

        return helper(root.left, root.right)
