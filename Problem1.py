# Time Complexity : O(n^2) in the worst case, O(n log n) for a balanced tree
# Space Complexity : O(n) auxiliary space for the recursion stack and path tracking
# Did this code successfully run on Leetcode : Yes
class Solution:
    def pathSum(self, root, targetSum):
        res = []

        def dfs(node, remaining, path):
            if not node:
                return
            path.append(node.val)
            remaining -= node.val
            if not node.left and not node.right:
                if remaining == 0:
                    res.append(list(path))
            dfs(node.left, remaining, path)
            dfs(node.right, remaining, path)
            path.pop()
        dfs(root, targetSum, [])
        return res
