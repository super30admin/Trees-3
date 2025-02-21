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
        if not root:
            return True
        def isMirror(leftnode,rightnode):
            if leftnode is None and rightnode is None:
                return True
            if leftnode is None or rightnode is None:
                return False
            if leftnode.val != rightnode.val:
                return False
            return (isMirror(leftnode.left,rightnode.right)and isMirror(leftnode.right,rightnode.left))

        

        return isMirror(root.left,root.right)