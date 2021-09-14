# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach to solve this problem:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def helper(self, root, sum_tot, lst, result):                                           # Using a helper function
        if root.left is None and root.right is None:
            if root.val == sum_tot:                                                         # go till last and if value equal to sum_tot  
                result = [lst + [root.val]]                                                 # Add the sum of lst and root
        if root.left:                                                                       # If have a left node
            self.helper(root.left, sum_tot - root.val, lst + [root.val],result)
        if root.right:                                                                      # If have a right node
            self.helper(root.left, sum_tot - root.val, lst + [root.val],result)
        return result
            
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        return self.helper(root, sum, [], [])