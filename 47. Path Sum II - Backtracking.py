# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    path = []
    target = 0

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.target = targetSum
        self.path = []

        if root is None:
            return self.result
        self.helper(root, 0)
        return self.result

    def helper(self, root, currSum):
        if root is None:
            return
            # action
        self.path.append(root.val)
        currSum = currSum + root.val

        # print(self.path, "before")
        if root.left is None and root.right is None:
            if currSum == self.target:
                # print(self.path, "in if")
                self.result.append(self.path)
        # recursion
        self.helper(root.left, currSum)
        self.helper(root.right, currSum)
        # backtracking
        self.path.pop(-1)
        # print(self.path, "After")

# TC =O(n).
# Space complexity : O(n).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No