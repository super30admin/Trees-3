// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: using 1 pointer at left and one pointer at right and comparing if they are simillar





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if root == None:
            return True
        
        return self.check(root.left, root.right)
        
    
    def check(self, p1: TreeNode, p2: TreeNode):
        if p1 == None and p2 == None:
            return True
        if p1 == None or p2 == None:
            return False
        if p1.val != p2.val:
            return False
        
        return self.check(p1.left, p2.right) and self.check(p1.right, p2.left)
