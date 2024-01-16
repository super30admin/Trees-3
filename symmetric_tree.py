""" Explanation: Firstly, I check if either the roots are null or not or if their values are unequal, since it won't be a root then. 
    Next once we have the two roots, we recursively traverse and check if the left and right nodes are equal or not. If they're, we return
    true, else return false.
    Time Complexcity: O(n)
    Space Complexcity: O(n) 
    TC passed on LC: Yes
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def isSame(root1, root2):
            if not root1 and not root2:
                return True
            if (not root1 and root2) or (root1 and not root2) or (root1.val != root2.val):
                return False
            left = isSame(root1.left, root2.right)
            right = isSame(root1.right, root2.left)
            return left and right
        
        if not root:
            return True
            
        return isSame(root.left, root.right)
        