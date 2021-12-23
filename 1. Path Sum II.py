class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root, targetSum):
        # Time Complexity - O(n)
        # Space Complexity - O(h) - as the max number of elements in the stack at any time is the height of the tree

        self.result = []
        if not root:
            return self.result
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self, root, targetSum, sum_, path):
        # Base Condition
        if root is None:
            return

        sum_ += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if sum_ == targetSum:
                self.result.append(path.copy())

        self.helper(root.left, targetSum, sum_, path)
        self.helper(root.right, targetSum, sum_, path)
        path.pop()