# Time Complexity : O(n)
# Space Complexity : O(n) - stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # Store Stack for traversal
        stack = []
        # val of sum so far
        val = 0
        # final output
        paths = []
        # current path
        path = []
        # traversal
        while root is not None or stack:
            # Check if root is None
            while root is not None:
                # Calculate the sum so far
                val += root.val
                # Append value to path 
                path.append(root.val) 
                # Store in stack a copy not a reference
                stack.append((root, val, path[:]))
                root = root.left
            
            root, val, path = stack.pop(len(stack)-1)
            # condition to check if targetSum is reached
            if root.left is None and root.right is None and val == targetSum:
                paths.append(path)                
            # check the right tree
            root = root.right
        return paths
            