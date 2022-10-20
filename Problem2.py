# Time Complexity : O(n) n is the number of elements in the tree
# Space Complexity : O(h)  here h is the height of the tree that means the recursive stack will have values upto the height of tree max
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - Here we traverse the trees left.left and comapre to right.right and then left.right and right.left to check for symmetric


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        return self.dfs(root.left, root.right)
    
    def dfs(self, left, right):
        print(left,right)
        if left==None and right== None:
            return True
        
        if left==None or right==None or left.val != right.val:
            print(self.isSymmetric)
            return False
        return self.dfs(left.left, right.right) and self.dfs(left.right, right.left)
