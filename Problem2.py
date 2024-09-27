"""

    Student : Shahreen Shahjahan Psyche
    Time Complexity : O(N) [It is touching every node once]
    Space Complexity : O(H) [Height of the tree]

    This code successfully passed all the test cases in Leetcode

"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        # edge case
        if root is None:
            return True
        
        # when only root is there
        if root.left is None and root.right is None:
            return True
        
        # Recursively 
        def helper(leftRoot, rightRoot):
            
            # if I end up at NULL position in each side that means I found the
            # same value in both sides and ended up here. So thats why I am
            # returning true
            if leftRoot is None and rightRoot is None:
                return True
            
            # if my one side became NULL but the other didnt, that means the
            # tree is not creating a mirror image
            if leftRoot is None and rightRoot is not None:
                return False
            
            if leftRoot is not None and rightRoot is None:
                return False
            
            res = True
            # checking whether the values of the current rooots of both side
            # is same or not!
            if leftRoot.val == rightRoot.val:
                res = helper(leftRoot.left , rightRoot.right) and helper(leftRoot.right, rightRoot.left)
            else:
                return False
            return res
        
        
        
        
        return helper(root.left, root.right)
        
        