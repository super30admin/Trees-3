# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag=True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.check(root.left,root.right)
        return self.flag
    def check(self,root1,root2):
        print("x")
        if root1 is None and root2 is None:
            
            return 
        elif (root1 is None or root2 is None) :
            
            self.flag=False
            return 
        
        if not(root1.val == root2.val):
           
            self.flag=False
        self.check(root1.left,root2.right)
        self.check(root1.right,root2.left)
        
        