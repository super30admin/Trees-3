## Problem1 (https://leetcode.com/problems/path-sum-ii/)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy

class Solution:
    # Time Complexity: O(N^2) in the worst case (completely unbalanced/skewed tree).
    # Why: We visit each node once O(N), but at each node, we do a copy.deepcopy() of the path.
    # The path length can grow up to N, meaning the copies take 1 + 2 + 3 + ... + N = O(N^2) time.
    # (For a perfectly balanced tree, it would be O(N log N)).
    #
    # Space Complexity: O(N^2) in the worst case for auxiliary space.
    # Why: The recursion call stack goes as deep as N. Because we create a deep copy of the 
    # array at every single step and pass it down, the stack holds references to arrays 
    # of size 1, 2, 3... N, which takes up O(N^2) memory.
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        
        # Helper function to perform Depth First Search (DFS) traversing the tree
        def helper(node, currentSum, nodesInPath):
            nonlocal targetSum, result
            
            # Base case: if the node is null, we've reached past a leaf; backtrack
            if node == None:
                return

            # Add the current node's value to our running total
            currentSum += node.val
            
            # Append the current node's value to track the path we took to get here
            nodesInPath.append(node.val)
            
            # Check if this is a leaf node (no left or right children) AND 
            # if our running sum exactly equals the target sum
            if node.left == None and node.right == None and currentSum == targetSum:
                # We found a valid path! Add this specific path to our final results
                result.append(nodesInPath)

            # Recursively explore the left and right subtrees.
            # We use copy.deepcopy() to ensure that the left and right branches get their own 
            # independent copies of the path list, preventing them from modifying each other's paths.
            helper(node.left, currentSum, copy.deepcopy(nodesInPath))
            helper(node.right, currentSum, copy.deepcopy(nodesInPath))

        # Kick off the DFS with the root node, a starting sum of 0, and an empty path
        helper(root, 0, [])
        return result