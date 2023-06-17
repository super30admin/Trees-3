#Time complexity is: O(n)
#Space complexity is: O(h) where h is the height of the tree
#Program ran successfully on leetcode
#No issues faced while coding

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
        #If the root is NOne we will be returning True
        if root is None:
            return True
        #We will be sending the left and right values of the root to the heloer function
        return self.helper(root.left, root.right)
    
    def helper(self,left,right):
       #If the left and right values are nonr we will return True
        if left is None and right is None:
            return True
        #If one of the left or right value is None, or if the values are not equal, we will return False
        elif left is None or right is None or left.val != right.val:
            return False
        #We will be performing and operation between left and right values and we will be returning the result
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)


