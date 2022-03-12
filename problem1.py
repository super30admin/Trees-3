# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

TC: O(n)
SC: O(h)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []

        currsum = 0
        self.result = []
        path = []
        self.helper(root, targetSum, currsum, path)
        return self.result

    def helper(self, root, targetSum, currsum, path):
        # base case
        if root is None:
            return None

        if root.left is None and root.right is None and targetSum == currsum + root.val:
            path.append(root.val)
            self.result.append(path.copy())
            path.pop()

        # logic
        path.append(root.val)
        currsum += root.val
        self.helper(root.left, targetSum, currsum, path)
        self.helper(root.right, targetSum, currsum, path)
        path.pop()
        currsum -= root.val

