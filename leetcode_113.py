class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def dfs(node, remaining, path):
            if not node:
                return

            path.append(node.val)
            remaining -= node.val

           
            if not node.left and not node.right and remaining == 0:
                res.append(path[:])

            dfs(node.left, remaining, path)
            dfs(node.right, remaining, path)

            path.pop()  # backtrack

        dfs(root, targetSum, [])
        return res
        