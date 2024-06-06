# Time Complexity : O(n)
# Space Complexity : O(h)
class Solution:
    def __init__(self):
        self.result = []
        self.path = []

    def dfs(self, root, target, curSum):
        if root is None:
            return
        curSum += root.val
        self.path.append(root.val)
        if root.left is None and root.right is None and curSum == target:
            self.result.append(list(self.path))
        self.dfs(root.left, target, curSum)
        self.dfs(root.right, target, curSum)
        self.path.pop()

    def pathSum(self, root, targetSum):
        if root is None:
            return self.result
        self.dfs(root, targetSum, 0)
        return self.result

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

solution = Solution()

# Example 1:
root = TreeNode(5)
root.left = TreeNode(4)
root.left.left = TreeNode(11)
root.left.left.left = TreeNode(7)
root.left.left.right = TreeNode(2)
root.right = TreeNode(8)
root.right.left = TreeNode(13)
root.right.right = TreeNode(4)
root.right.right.left = TreeNode(5)
root.right.right.right = TreeNode(1)
print(solution.pathSum(root, 22))  # Expected output: [[5, 4, 11, 2], [5, 8, 4, 5]]

# Example 2:
solution = Solution() # Reinitializing for Global Variables
root = TreeNode(1)
root.left = TreeNode(2)
print(solution.pathSum(root, 1))  # Expected output: []

# Example 3:
solution = Solution()
root = TreeNode(1)
root.left = TreeNode(2)
print(solution.pathSum(root, 3))  # Expected output: [[1, 2]]