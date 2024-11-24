"Time complexity is O(N)"
"Space Complexity is O(H)"
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root, targetSum):
        def dfs(node, current_path, current_sum):
            if not node:
                return
            
            # Include the current node in the path
            current_path.append(node.val)
            current_sum += node.val
            
            # Check if it's a leaf node and the sum matches
            if not node.left and not node.right and current_sum == targetSum:
                result.append(list(current_path))
            
            # Recur for left and right children
            dfs(node.left, current_path, current_sum)
            dfs(node.right, current_path, current_sum)
            
            # Backtrack
            current_path.pop()
        
        result = []
        dfs(root, [], 0)
        return result
