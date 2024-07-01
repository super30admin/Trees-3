#Time Complexity : O(n)
#Space Complexity : O(h) + O(n . h)
#Any problem you faced while coding this : -

#This approach is to use backtracking to go back to the previous state of the node in order to fetch the path until that node. We create a new deep copy of the path when we find the current sum == target sum.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, targetSum, 0, list())
        return self.result

    def helper(self, root, targetSum, currSum, path):
        #base
        if root is None:
            return

        #logic
        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None and currSum == targetSum:
            self.result.append(list(path))

        self.helper(root.left, targetSum, currSum, path)
        self.helper(root.right, targetSum, currSum, path)
        path.pop()
