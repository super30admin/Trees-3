#Time Complexity :O(n)
#Space Complexity :O(h) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root.left,root.right)

    def helper(self,left,right):
        if left==None and right==None:
            return True
        if left==None or right==None:
            return False
        
        first=self.helper(left.left,right.right)
        second=self.helper(left.right,right.left)

        if (left.val==right.val) and first and second:
            return True
        else:
            return False
        