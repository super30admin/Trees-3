# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#All TC on leetcode passed


class Solution:
    #here we check if root exists or not. If not then return true as its symmetric. If exists then check if root.left and root.right are mirror images. 
    #time complexity - O(n) - traversing every node
    #space complexity - O(h) - ht of tree
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        return self.isMirror(root.left, root.right)
    
    def isMirror(self, left, right):
        if not left and not right:
            return True
        
        if not left or not right:
            return False

        if left.val==right.val:
            return self.isMirror(left.left, right.right) and self.isMirror(left.right, right.left)
        