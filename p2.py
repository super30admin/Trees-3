class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def isSym(root1, root2):
            if root1 == None and root2 == None:
                return True
            elif root1 == None and root2 != None:
                return False
            elif root1 != None and root2 == None:
                return False
            else:
                if root1.val != root2.val:
                    return False
                else:
                    return isSym(root1.left, root2.right) and isSym(root1.right,root2.left)
        return root == None or isSym(root.left,root.right)