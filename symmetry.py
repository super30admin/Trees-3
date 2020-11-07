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
        #         def sym(root1,root2):
        #             if root1==None and root2==None:
        #                 return True
        #             if root1==None or root2==None:
        #                 return False

        #             return root1.val==root2.val and sym(root1.left,root2.right) and sym(root1.right,root2.left)
        #         return sym(root,root)

        s = []
        s.append(root)
        s.append(root)
        while s:
            o1 = s.pop()
            o2 = s.pop()
            if o1 is None and o2 is None:
                continue
            if o1 is None or o2 is None:
                return False
            if o1.val != o2.val:
                return False
            s.append(o1.left)
            s.append(o2.right)
            s.append(o2.left)
            s.append(o1.right)
        return True
        # time-O(n) space-O(breadth)