# Time Complexity: O(n), traversing n nodes
# Spcae Complexity: O(h), for the recursive stack
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, [], 0, targetSum)
        return self.result

    def helper(self, root, path, currSum, targetSum):
        # BAse
        if root == None:
            return

        # Logic
        currSum += root.val
        # action
        path.append(root.val)

        # Check if it's leaf node and sum matches
        if root.left == None and root.right ==None:
            if targetSum == currSum:
                self.result.append(list(path))
        # Recurse
        self.helper(root.left, path, currSum, targetSum)
        self.helper(root.right, path, currSum, targetSum)

        # backtrack
        path.pop()