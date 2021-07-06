# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []

        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result

    def helper(self, root: TreeNode, targetSum: int, currSum: int, path: List[int]) -> None:
        # base
        if not root:
            return

        # logic
        currSum += root.val
        path.append(root.val)

        # If leaf node is reached and if root-to-leaf path sum equals targetSum, add the path list to the result
        if not root.left and not root.right:
            if currSum == targetSum:
                self.result.append(list(path))

        self.helper(root.left, targetSum, currSum, path)
        self.helper(root.right, targetSum, currSum, path)

        # backtrack
        path.pop()

