# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root) -> bool:
        if root == None:
            return True
        
        def recursion(left,right):
            if left == None and right == None:
                return True
            elif left == None or right == None:
                return False
            if left.val != right.val:
                return False

            return recursion(left.right,right.left) and recursion(left.left,right.right)

        return recursion(root.left,root.right)
    
#TC: O(n)
#SC: O(1)