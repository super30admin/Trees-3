# 113. Path Sum II
# TC: O(N^2) where N is the number of nodes in the tree
# SC: O(H) where H is the height of the tree, for recursion stack
# Did this code successfully run on Leetcode: Yes

# Approach: 
# Depth-First Search (DFS): We use recursive DFS to traverse the binary tree from root to leaf, exploring one branch completely before backtracking.
# Path Tracking: As we traverse, we maintain a current path list that records all nodes visited along the current exploration path.
# Sum Accumulation: We keep a running sum of node values as we traverse down the tree.
# Leaf Node Checking: When we reach a leaf node (no children), we check if the accumulated sum equals our target sum.
# Result Collection: If we find a valid path (leaf node with correct sum), we add a copy of the current path to our result list.
# Backtracking: After exploring a node's subtrees, we remove it from the current path (backtrack) before exploring alternative paths.
# Base Case Handling: We handle empty nodes (null) as our base case to stop recursion.
# This approach efficiently finds all valid paths by exploring all possibilities while using backtracking to prevent using excessive memory. The time complexity is O(N²) in the worst case because we might need to create a copy of the path (which could be as long as N nodes) for potentially all leaf nodes.


from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        
        def helper(node, target, current_sum, path):
            # Base case: empty node
            if not node:
                return
                
            # Add current node to path and update sum
            current_sum += node.val
            path.append(node.val)
            
            # Check if we're at a leaf node and sum matches target
            if not node.left and not node.right and current_sum == target:
                # Important: create a copy of the path to add to result
                result.append(path[:])
            
            # Recurse to children
            helper(node.left, target, current_sum, path)
            helper(node.right, target, current_sum, path)
            
            # Backtrack by removing current node from path
            path.pop()
        
        # Start DFS from root
        helper(root, targetSum, 0, [])
        return result
        