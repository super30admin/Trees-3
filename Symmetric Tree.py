# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    #function to check if left subtree and right subtree of given root are equal
    def isSame(self, left_root,right_root):
        #check if both roots are null, then symmetric tree
        if left_root==None and right_root==None:
            return True
        #check if one of them is null, then not symmetric
        if left_root==None or right_root==None:
            return False
        #check if their values are equal, also check same for their left and right subtree
        return (left_root.val==right_root.val) and self.isSame(left_root.left,right_root.right) and self.isSame(left_root.right,right_root.left)

    #main function to check if given root is None and if not, call helper function recursively
    def isSymmetric(self, root: TreeNode) -> bool:
        if root==None:
            return True

        return self.isSame(root.left, root.right)
