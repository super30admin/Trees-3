# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity : o(N^2)
# Space Complexity : O(N)
class Solution:

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        if not root:
            return self.result
        self.helper(root, targetSum, [])
        return self.result

    def helper(self, root, currSum, path):
        if not root:
            return None
        path.append(root.val)
        if root.left == None and root.right == None and currSum == root.val:
            self.result.append(list(path))
        else:
            self.helper(root.left, currSum - root.val, path)
            self.helper(root.right, currSum - root.val, path)
        path.pop()


