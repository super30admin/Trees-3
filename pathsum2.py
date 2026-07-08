class Solution:
    def pathSum(self, root, targetSum):

        result = []

        def dfs(node, remaining, path):
            if not node:
                return

            # choose
            path.append(node.val)
            remaining -= node.val

            # leaf node
            if not node.left and not node.right:
                if remaining == 0:
                    result.append(path[:])

            # explore
            dfs(node.left, remaining, path)
            dfs(node.right, remaining, path)

            # backtrack
            path.pop()

        dfs(root, targetSum, [])

        return result

# TC - O(h) h = height of tree because we only append valid path
# SC - O(h) result is O(h) excluding path used for storing temporary paths