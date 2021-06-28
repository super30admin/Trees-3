# Time Complexity : O(N)
# Space Complexity : O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.paths = []
        self.path = []

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.helper(root, targetSum, 0, self.path)
        return self.paths

    def helper(self, root, targetSum, total, path):
        # base
        if root == None or root.val == None or targetSum < 0:
            return
        total = total + root.val
        if targetSum == total and root.right is None and root.left is None:
            self.paths.append(path[:] + [root.val])
        # logic
        path.append(root.val)
        self.helper(root.left, targetSum, total, path)
        self.helper(root.right, targetSum, total, path)
        path.pop()



