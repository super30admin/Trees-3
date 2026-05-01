# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n)
# Space Complexity --> O(log n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, targetSum, 0, [])
        return self.result
    
    def helper(self, root, targetSum, currSum, currList):
        # base
        if root is None:
            return
        # logic
        currSum = currSum + root.val
        currList.append(root.val)
        if root.left is None and root.right is None:
            if currSum==targetSum:
                self.result.append(list(currList))

        self.helper(root.left, targetSum, currSum, currList)
        self.helper(root.right, targetSum, currSum, currList)
        # backtrack
        currList.pop()
