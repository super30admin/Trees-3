"""
Traverse using DFS, keep current path and sum.
If it's a leaf and sum == target, add path to result.
Backtrack after visiting left and right children.
"""
"""
Time Complexity: O(N) – Visit every node once.
Space Complexity: O(H) – Recursion stack, where H is the height of the
"""

from typing import Optional, List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class pathSum:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def dfs(node, path, current_sum):
            if not node:
                return
            path.append(node.val)
            current_sum += node.val

            if not node.left and not node.right and current_sum == targetSum:
                res.append(list(path))
            else:
                dfs(node.left, path, current_sum)
                dfs(node.right, path, current_sum)

            path.pop()

        dfs(root, [], 0)
        return res


if __name__ == "__main__":

    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.right.left = TreeNode(5)
    root.right.right.right = TreeNode(1)

    obj = pathSum()
    print(obj.pathSum(root, 22))
