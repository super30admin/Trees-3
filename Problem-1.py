# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.paths = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.checkPath(root, 0, [], targetSum)
        return self.paths
        
    def checkPath(self, root, currSum, currPath, targetSum):
        # base case
        if not root:
            return

        # logic
        currSum += root.val
        currPath.append(root.val)
        
        if not root.left and not root.right:
            if currSum == targetSum:
                self.paths.append(currPath[:])

        self.checkPath(root.left, currSum, currPath, targetSum)
        self.checkPath(root.right, currSum, currPath, targetSum)
        currPath.pop()