# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    target = 0

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.target = targetSum
        if root is None:
            return self.result
        self.helper(root, 0, [])
        return self.result

    def helper(self, root, currSum, path):
        if root is None:
            return

        path.append(root.val)
        currSum = currSum + root.val
        if root.left is None and root.right is None:
            if currSum == self.target:
                print(path)
                self.result.append(path)

        self.helper(root.left, currSum, path.copy())
        self.helper(root.right, currSum, path.copy())

# TC =O(n^2).
# Space complexity : O(n^2).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No