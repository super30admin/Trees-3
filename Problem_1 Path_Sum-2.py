# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.result = []
        self.target = targetSum
        if root == None:
            return self.result
        self.helper(root, 0, [])
        return self.result

    def helper(self, root, curr_sum, path):

        # Base Condition
        if root == None:
            return

        # Logic
        curr_sum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if curr_sum == self.target:
                self.result.append(path.copy())

        # Recursive Approach
        self.helper(root.left, curr_sum, path)
        self.helper(root.right, curr_sum, path)

        # Back Track
        path.pop(len(path) - 1)


