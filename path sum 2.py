#TC: O(n*h)
#SC: O(h)

from copy import deepcopy
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []

        def xyz(root, path, currSum):
            if root == None:
                return
            
            currSum += root.val
            path.append(root.val)
            
            if root.left == None and root.right == None:
                if currSum == targetSum:
                    self.res.append(deepcopy(path))
            
            xyz(root.left, path, currSum)
            xyz(root.right, path, currSum)
            
            path.pop()
        
        xyz(root, [], 0)
        return self.res
