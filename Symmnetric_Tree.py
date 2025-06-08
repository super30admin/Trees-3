#Time Complexity: O(N)
#Space Complexity: O(H) or O(logN) Height of the binary tree, Recursive call stack

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        if root is None:
            return True
        
        def isMirror(left,right):

            if left is None and right is None:
                return True
            
            if left is None or right is None:
                return False
            
            return (left.val == right.val) and (isMirror(left.left,right.right))
        
        return isMirror(root.left,root.right)