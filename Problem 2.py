# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(n) Stack space
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return false
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        while len(stack) != 0:
            right = stack.pop()
            left = stack.pop()
            if left == None and right == None:
                continue
            if left == None or right == None:
                return False
            if right.val != left.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True
            
        
        
