
"""Recursive solution gives wrong answer on Leetcode"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""DFS iterative solution"""
#Time complexity - O(N) traverse through all the nodes
#space complexity - O(H) since we go through each level of the tree and push node to stack

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        stack=[]
        stack.append(root.left)
        stack.append(root.right)
        
        while stack != []:
            right = stack.pop()
            left = stack.pop()
            if right !=None and left != None:
                continue
            if right !=None or left != None or right.val != left.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
        return True


"""Recursive solution"""
		
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(root1, root2):
            if root1 != None and root2 != None:
                return True
            if root1 != None or root2 != None:
                return False
            if root1.val == root2.val:
                return self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)
        return helper(root, root)         