# Time Complexity = O(n)
# Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def dfs(node, path, current_sum):
            if not node:
                return
            path.append(node.val)
            current_sum += node.val
            #if it's a leaf node and sum equals targetSum
            if not node.left and not node.right and current_sum == targetSum:
                result.append(list(path))
            # Recursively traverse left and right subtrees
            dfs(node.left, path, current_sum)
            dfs(node.right, path, current_sum)
            # Backtrack to explore other paths
            path.pop()
        dfs(root, [], 0)
        return result