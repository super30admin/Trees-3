# T.C = O(n) S.C = O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    flag = True
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        self.helper(root.left,root.right)
        return self.flag

    def helper(self,left,right):

        if(left == None and right == None):
            return
        elif(left == None or right == None):
            self.flag = False
            return
        elif(left.val != right.val):
            self.flag = False
            return

        self.helper(left.left,right.right)
        self.helper(left.right,right.left)