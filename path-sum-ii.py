# Approach:
# Use DFS (Depth-First Search) with backtracking to explore all root-to-leaf paths, keeping track of the sum.
# If a path's sum matches targetSum, add it to the result; backtrack to explore other paths.
# Time Complexity: O(N) 
# Space Complexity:O(H) 
class Solution:
    def dfs(self, root, path, ans, remainingSum):
        if not root:
            return
        path.append(root.val)
        if not root.left and not root.right and remainingSum == root.val:
            ans.append(list(path))
        self.dfs(root.left, path, ans, remainingSum - root.val)
        self.dfs(root.right, path, ans, remainingSum - root.val)
        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []
        self.dfs(root, [], ans, targetSum)
        return ans