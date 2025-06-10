# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def pathSum(self, root, targetSum):
        def dfs(node, current, path):
            if not node:
                return
            current += node.val
            path.append(node.val)
            if not node.left and not node.right:
                if current == targetSum:
                    paths.append(path[:])
            dfs(node.left, current, path)
            dfs(node.right, current, path)
            path.pop()

        paths = []
        dfs(root, 0, [])
        return paths
