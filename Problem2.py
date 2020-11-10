# Time Complexity : O(n) (We have to pass throught every element of tree.)
# Space Complexity : O(1) (We are not storing any additional information. Also helper function is calling recusrion. )
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Make helper function that takes two roots. It compares value of both roots.
# - Helper function also calls helper function again where it compares left subtree of root1 with right subtree of root2. and compares right subtree of root1 with left subtree of root2
# - we return true if we reach at the end and return false if any one value of root is empty.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
#       If tree is empty return True
        if not root:
            return True
#       Call helper function on left and right subtree.
        return self.helper(root.left, root.right)
        
    def helper(self, root1, root2):
#       If both roots are None that means we reach the end without any error so return true.
        if not root1 and not root2:
            return True
#       If any one root is empty but not other we will return false because it is not symmetric.
        if root1 == None or root2 == None:
            return False
    
#       Now compare value of both roots and If it is true call helper function again for left and right subtree of both roots as explained in three line solution. We put and between returned result because if only both parts are true tree is symmetric.
        if root1.val == root2.val:
                return self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)
 
        
