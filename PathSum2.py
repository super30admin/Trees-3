# Time Complexity : O(h)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : If node is leaf and the current sum equals the target, add a copy of the path to the result.
# After recursive calls, pop the last element to restore the path for other branches.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, targetSum, 0 , [])
        return self.result

    def helper(self, root: Optional[TreeNode], targetSum: int, currSum: int, path: List[int]):
        if root is None:
            return

        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(list(path))

        self.helper(root.left, targetSum, currSum, path)
        self.helper(root.right, targetSum, currSum, path)

        path.pop()
    
        