# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# I used depth-first search with backtracking to explore all root-to-leaf paths.
# For each node, I subtract its value from the remaining target sum and store it in the current path.
# If I reach a leaf and the remaining sum is 0, I add a copy of the path to the result.
# After exploring both subtrees, I backtrack by removing the current node from the path.
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def dfs(node, path, remaining_sum):
            if not node:
                return

            path.append(node.val)
            remaining_sum -= node.val

            # If it's a leaf and the remaining sum is 0, we found a valid path
            if not node.left and not node.right and remaining_sum == 0:
                result.append(list(path))  # Copy the current path

            # Recurse left and right
            dfs(node.left, path, remaining_sum)
            dfs(node.right, path, remaining_sum)

            path.pop()  # Backtrack after visiting children

        dfs(root, [], targetSum)
        return result
