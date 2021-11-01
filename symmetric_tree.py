# // Time Complexity : O(n) where n is the number of nodes in the tree
# // Space Complexity : O(h) where h is the height of the tree 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        # approach 1: 
        # do level order traversal and check at each level if its a palindrome, if not return False
        
        # approach 2:
        # recursive | DFS | TC: O(n) n:nodes of the tree
        if not root:
            return True
        return self.helper(root.left,root.right) 
    
    def helper(self, root1, root2):
        
        if root1 and root2:
            if root1.val == root2.val:
                left = self.helper(root1.left,root2.right)
                right = self.helper(root1.right, root2.left)
                return left and right
        return root1 is root2
        
        