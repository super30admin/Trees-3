# time complexity: O(n)
# Space complexity: O(h) where h is the height of the tree
# Approach: I will use a recursive approach to solve this problem. I will define a helper function which will take two nodes as input and will check if the left node of the left node is equal to the right node of the right node and the right node of the left node is equal to the left node of the right node. I will return True if both the conditions are met else I will return False. I will call this helper function with the left and right node of the root node.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(left, right):
            # if both left and right are null
            if not left and not right:
                return True
            
            # if only one of left and right is null
            if not left or not right:
                return False
            
            # if both left and right are not null
            return (left.val == right.val and 
            dfs(left.left, right.right) and 
            dfs(left.right, right.left))
    
        return dfs(root.left, root.right)