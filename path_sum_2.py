"""
We need to pass the path (global variable) and total (local variable) varaibles to recursive calls. The Path is passed
as reference, so if we add a left child to the path to process it. and once processing is done, then we move to process right
then in such cases we need to pop() from the path. This is called BACKTRACKING. It is done when both left and right
subtree are processed and returning to the parent.

TC: O(n) and SC: O(h), copying path could be constant.

Another solution is to create a new list, at every node and DEEP COPY the path to it, since we are passing the same
reference of the list. This is space exhaustive.
TC: O(n*h) and SC: O(n) + O(n*h)

Difference between DEEP and SHALLOW copy?
deep copy: creating another array and coping
shallow copy: copy the reference of the list
"""

# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def helper(self, node, targetSum, total, path, ans):
        # base case
        if not node:
            return

            # action
        total += node.val
        path.append(node.val)
        if not node.left and not node.right:
            if total == targetSum:
                ans.append(path[:])  # since it is a global variable and will be changed, so copy the path at that time

        # recurse
        self.helper(node.left, targetSum, total, path, ans)
        self.helper(node.right, targetSum, total, path, ans)

        # backtrack
        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        ans = []
        self.helper(root, targetSum, 0, [], ans)
        print(ans)
        return ans
