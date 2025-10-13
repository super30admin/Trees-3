# Time Complexity : O(N)
# (Each node is visited once in the DFS traversal)
#
# Space Complexity : O(H)
# (H = height of the tree due to recursion stack, plus space for the current path)
#
# Did this code successfully run on Leetcode : Yes
#
# Any problem you faced while coding this :
# Remembering to pop the last element (backtracking) after exploring both children,
# otherwise the path list keeps growing and produces incorrect paths.

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # Result list to store all valid root-to-leaf paths whose sum == targetSum
        self.res = []

        # Start recursive DFS traversal
        self.helper(root, targetSum, 0, [])
        return self.res

    def helper(self, root, targetSum, current_sum, path):
        # Base case: if the current node is None, stop recursion
        if not root:
            return 0

        # Add the current node's value to running sum and current path
        current_sum += root.val
        path.append(root.val)

        # If it's a leaf node (no left or right child)
        if not root.left and not root.right:
            # Check if the current path sum equals the target sum
            if current_sum == targetSum:
                # Append a COPY of the path to results (since path is mutable)
                self.res.append(list(path))

        # Recurse down the left and right subtrees
        left = self.helper(root.left, targetSum, current_sum, path)
        right = self.helper(root.right, targetSum, current_sum, path)

        # Backtrack: remove the current node's value before returning to the caller
        path.pop()
