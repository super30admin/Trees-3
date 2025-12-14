# Time Complexity : O(n)  -> Visit each node once
# Space Complexity : O(h) -> Recursion stack + path list, h = height of tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
# Use DFS to traverse the tree while keeping track of the current path and its sum.
# At each node, add its value to the running total and append it to the path list.
# When a leaf is reached, check if the running total equals targetSum and store a copy of the path if it does.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, 0, [], targetSum)
        return self.result
    
    def helper(self, root, total, path, targetSum):
        if not root:
            return
        
        # Include current node in path and update running total
        total += root.val
        path.append(root.val)
        
        # Check if leaf and sum equals target
        if not root.left and not root.right and total == targetSum:
            self.result.append(list(path))  # Make a copy of path
        
        # Recurse left and right
        self.helper(root.left, total, path, targetSum)
        self.helper(root.right, total, path, targetSum)
        
        # Backtrack: remove current node before returning
        path.pop()
