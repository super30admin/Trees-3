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

        def helper(root1, root2):
            # If both are null, it's a match.
            if not root1 and not root2:
                return True
            
            #Mismatch cases
            if not root1 or not root2:
                return False

            if root1.val != root2.val:
                return False

            return helper(root1.left, root2.right) and helper(root1.right, root2.left)

        #In order to be symmetric, left should match right
        return helper(root.left, root.right)
        

    #TC : O(n)
    #SC : O(n)