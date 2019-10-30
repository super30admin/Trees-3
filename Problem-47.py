# leetcode -symeetric tree -101
#Time complexity -O(N)
#space complexity -O(1)
#Aproach - left hand should be equal to right hand. if one left node is null and right node has value then it is false. Both are None then return True.



# Definition for a binary tree node.
  class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.isMirror(root,root)
    def isMirror(self,root1,root2):
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False
        if root1.val ==root2.val:
            return self.isMirror(root1.left,root2.right) and self.isMirror(root1.right,root2.left)
        
        