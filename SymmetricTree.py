# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity is O(n) and Space complexity is O(h)
class Solution(object):
    def isSymmetric2(self,left,right):
        if(left is None and right is None):
            return True
        elif(left is None or right is None):
            return False
        else:
            return (left.val == right.val) and self.isSymmetric2(left.left,right.right) and self.isSymmetric2(left.right,right.left)
        
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root is None):
            return True
        else:
            return self.isSymmetric2(root.left,root.right)