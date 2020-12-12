# Time: O(N)
# Space: O(N)
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> bool:
        stack = []
        current_sum = 0
        path = []
        paths = []
        while root or stack:
            while root:
                path = path + [root.val]
                current_sum += root.val
                stack.append((root, current_sum, path))
                root = root.left
            root, current_sum, path = stack.pop()
            if not root.left and not root.right:
                if current_sum == sum:
                    paths.append(path)
            root = root.right
        return paths