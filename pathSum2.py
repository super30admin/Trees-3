# Move down one branch of the tree, keeping track of path and sum
# Upon reaching a Leaf Node, backtrack to last node
# Continue until all possible root to leaf paths are checked
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def dfs(node, path, curSum):
            # Base
            if not node:
                return
            # Include cur node in path
            path.append(node.val)
            curSum += node.val
            # Check if its a leaf node and the sum matches
            if not node.left and not node.right and curSum == targetSum:
                res.append(list(path))  # Append a copy of the path
            # Recurse to l and r children
            dfs(node.left, path, curSum)
            dfs(node.right, path, curSum)
            # Backtrack: Remove the cur node from the path
            path.pop()

        dfs(root, [], 0)

        return res
        # T: O(n), S: O(h)
