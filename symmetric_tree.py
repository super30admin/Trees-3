class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def mirors(root1,root2):
            if (root1 is None and root2 is None): 
                return True
            if (root1 is None or root2 is None): 
                return False
            if root1.val==root2.val:
                return mirors(root1.left,root2.right) and mirors(root1.right,root2.left)
            else:
                return False
        
        return mirors(root,root)