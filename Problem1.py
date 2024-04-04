#T.C. O(n * h)
#S.C. O(n * h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def helper(self, root, currSum, targetSum, path):
        if root is None:
            return
        currSum += root.val
        newPath = path + [root.val]
        if root.left is None and root.right is None:
            if currSum == targetSum:
                self.result.append(newPath)
                
        self.helper(root.left, currSum, targetSum, newPath)
        self.helper(root.right, currSum, targetSum, newPath)
    
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.helper(root, 0, targetSum, [])
        return self.result
    
    
