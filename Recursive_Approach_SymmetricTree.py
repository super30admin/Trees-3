# // Time Complexity : O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isvalid=True
    def isSymmetric(self, root: TreeNode) -> bool:
        if(root==None):
            return True
        self.helper(root.left,root.right)
        return self.isvalid
    def helper(self,left,right):
        if(left==None and right==None):
            return
        if(left==None or right==None or left.val!=right.val):
            self.isvalid=False
            return
        self.helper(left.left,right.right)
        self.helper(left.right,right.left)