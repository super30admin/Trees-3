#Problem 101. SYMMETRIC TREE
# TIME COMPELXITY: O(N) as we need to compare each node N
# SPACE COMPLEXITY: O(H) where H denotes the height of the tree as we are doing recursion stack

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if root is None:
            return True
        
        return self.symmetricCheck(root.left,root.right)

    def symmetricCheck(self,left,right):
        if left is None and right is None:
            return True

        if left is None or right is None:
            return False
        
        if left.val!=right.val:
            return False
        
        return self.symmetricCheck(left.left,right.right) and self.symmetricCheck(left.right,right.left)
        
