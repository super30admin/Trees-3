#
# Time Complexity  = O(n)
# Space Complexity  = O(h) recursive stack space
#

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def helper(l,r):
            if l==None:
                if r==None:
                    return True
                else:
                    return False
            elif r==None:
                return False
            else:
                if r.val == l.val:
                    return helper(l.right,r.left) and helper(r.right,l.left)
                else:
                    return False
        if not root:
            return True
        return helper(root.left, root.right)
