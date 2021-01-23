# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Interate and traverse in the order left.left and right.right take care of the stopping condition

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    isValid = True
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        self.helper(root.left,root.right)
        return self.isValid
    
    def helper(self,Left,Right):
        if Left == None and Right == None:
            return
        if  Left == None or Right == None or Left.val != Right.val:
            self.isValid = False
            return
        self.helper(Left.left,Right.right)
        self.helper(Left.right,Right.left)
        