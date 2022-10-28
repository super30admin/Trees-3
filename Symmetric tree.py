# TC - O(n)
# SC - O(h)
# Does this code run on Leetcode: Yes
# Did you find any difficulty while coding this solution: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        actual = root.left
        image = root.right
        def recur(actual, image):
            if actual == None and image == None:
                return True
            if (actual == None and image != None): 
                return False
            if (actual != None and image == None):
                return False
            if actual.val != image.val:
                return False
            return recur(actual.left, image.right) and recur(actual.right, image.left)
        return recur(actual, image)
        