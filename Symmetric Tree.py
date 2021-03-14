'''
Time Complexity: O(n)
Space Complexity: O(n) Height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def isSymmetric(self, root):

        def isSym(root1, root2):
            if root1 == None and root2 == None:
                return True
            elif root1 == None and root2 != None:
                return False
            elif root1 != None and root2 == None:
                return False
            else:
                if root1.val != root2.val:
                    return False
                else:
                    return isSym(root1.left, root2.right) and isSym(root1.right, root2.left)

        return root == None or isSym(root.left, root.right)
