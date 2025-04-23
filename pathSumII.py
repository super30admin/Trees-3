# Approach: Use DFS with backtracking by modifying the path list in-place.

# Time Complexity: O(N * H)
# Space Complexity: O(H) + O(L * H)

from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# BACKTRACKING SOLUTION
class SolutionBacktracking:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        self.helper(root, targetSum, 0, [], result)
        return result

    def helper(self, root, targetSum, currSum, path, result):
        if not root:
            return

        currSum += root.val
        path.append(root.val)

        if not root.left and not root.right and currSum == targetSum:
            result.append(list(path))

        self.helper(root.left, targetSum, currSum, path, result)
        self.helper(root.right, targetSum, currSum, path, result)

        path.pop()


# RECURSION SOLUTION
# Approach: Use pure recursion and create a new path list at each level.

# Time Complexity: O(N * H)
# Space Complexity: O(H) + O(L * H)


class SolutionPureRecursion:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        return self.helper(root, targetSum)

    def helper(self, node, remaining_sum):
        if not node:
            return []

        if not node.left and not node.right and node.val == remaining_sum:
            return [[node.val]]

        left_paths = self.helper(node.left, remaining_sum - node.val)
        right_paths = self.helper(node.right, remaining_sum - node.val)

        return [[node.val] + path for path in left_paths + right_paths]


def build_sample_tree():
    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.right.right = TreeNode(1)
    return root


root = build_sample_tree()
target_sum = 22

print("Backtracking Solution:")
print(SolutionBacktracking().pathSum(root, target_sum))

print("\nRecursion Solution:")
print(SolutionPureRecursion().pathSum(root, target_sum))
