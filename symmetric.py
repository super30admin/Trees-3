#Time Complexity: O(N).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.result = True
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def mirror(t1,t2):
            if not t1 and not t2:
                return
            if (t1 and not t2)or (t2 and not t1):
                self.result= False
                return
            if t1.val!=t2.val:
                self.result=False
                return
            mirror(t1.left,t2.right)
            mirror(t1.right,t2.left)
            
        mirror(root,root)
        return self.result