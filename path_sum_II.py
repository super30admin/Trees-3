# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Approach:
# Perform a depth-first search (DFS) to traverse all root-to-leaf paths. At each node, keep track of the current path and its sum.
# If a leaf node is reached and the sum of the path equals the targetSum, add the path to the result.
# Backtrack after visiting each node to explore other paths.

# Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited once.
# Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.
# Did this code successfully run on Leetcode: Yes.
# Any problem you faced while coding this: No.


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(node, current_path, current_sum):
            if not node:  # Base case: if the node is None, return
                return
            
            # Add the current node's value to the path and update the sum
            current_path.append(node.val)
            current_sum += node.val
            
            # Check if it's a leaf node and the sum matches targetSum
            if not node.left and not node.right and current_sum == targetSum:
                result.append(list(current_path))  # Add a copy of the current path to the result
            
            # Recur for left and right children
            dfs(node.left, current_path, current_sum)
            dfs(node.right, current_path, current_sum)
            
            # Backtrack: remove the current node's value from the path
            current_path.pop()
        
        result = []  # Initialize the result list
        dfs(root, [], 0)  # Start DFS with an empty path and sum of 0
        return result