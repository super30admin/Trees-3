# Time Complexity = O(n*h) | Space Complexity = O(h) + O(n*h)

from typing import Optional
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> list[list[int]]:
        self.result = []
        self.helper(root, targetSum, [], 0)
        return self.result

    def helper(self, root: Optional[TreeNode], targetSum: int, curr_arr: [int], curr_sum):
        # base case
        if root is None: return

        arr_cp = list(curr_arr)
        curr_sum += root.val
        arr_cp.append(root.val)

        if root.left is None and root.right is None:
            if curr_sum == targetSum:
                self.result.append(arr_cp)
                return

        self.helper(root.left, targetSum, arr_cp, curr_sum)

        self.helper(root.right, targetSum, arr_cp, curr_sum)

