# Time Complexity: O(n).
# Space Complexity: O(n) for recursion stack
# Did this code successfully run on Leetcode : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, l=None, r=None):
#         self.val = val
#         self.l = l
#         self.r = r
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        def helper(l,r):
            if l==None and r==None:
                return True
            if l==None or r ==None:
                return False
            
            if l.val!=r.val:
                return False
            else:
                lres=helper(l.left,r.right)
                rres=helper(l.right,r.left)
                return lres and rres

        return helper(root,root)