# Time complexity: O(n)
# Space complexity: O(h)

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
        if root is None:
            return True
        
        def helper(left, right):
            if left is None and right is None:
                return True
            elif left is None or right is None :
                return False
            elif left.val != right.val:
                return False
        
            return helper(left.right,right.left) and helper(left.left,right.right)

        return helper(root.left,root.right)
                
