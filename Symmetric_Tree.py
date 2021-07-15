# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Space:O(n)
#Time:O(n)
class Solution:
    def __init__(self):
        self.left = []
        self.right = []
    def isSymmetric(self, root: TreeNode) -> bool:
        
        
        def helper_left(root):
            if not root:
                self.left.append("*")
                return
            self.left.append(root.val)
            helper_left(root.left)
            helper_left(root.right)
        
        def helper_right(root):
            if not root:
                self.right.append("*")
                return
            self.right.append(root.val)
            helper_right(root.right)
            helper_right(root.left)
        
        if not root:
            return True
        helper_left(root.left)
        helper_right(root.right)
        print(self.right,self.left)
        if self.right == self.left:
            return True
        return False
        
        