# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        result = []
        path = []

        def helper(root, prevSum, path):
            if root is None:
                return

            currSum = prevSum + root.val
            path.append(root.val)

            if root.left is None and root.right is None:
                if currSum == targetSum:
                    result.append(list(path))

            helper(root.left, currSum, path)

            helper(root.right, currSum, path)

            path.pop(-1)

        helper(root, 0, path)

        return result
