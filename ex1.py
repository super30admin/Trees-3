# Time Complexity: O(n^2)
# Space Complexity: O(n)

class Solution:
    def __init__(self):
        self.result = []

    def helper(self, root: Optional[TreeNode], res: int, path: List[int], targetSum: int) -> None:
        if root is None:
            return

        # Update running sum and add current node to path
        res += root.val
        path.append(root.val)

        # if leaf, check if sum == target
        if root.left is None and root.right is None:
            if res == targetSum:
                # Append a shallow copy of path since path is mutable
                self.result.append(path[:])

        # Recurse into left and right children
        self.helper(root.left, res, path, targetSum)
        self.helper(root.right, res, path, targetSum)

        # Backtrack: remove last node before returning up the stack
        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, 0, [], targetSum)
        return self.result
