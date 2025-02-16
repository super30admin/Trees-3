# Time O(n) or h
# Space: O(n)
import copy

class Solution:
    def __init__(self):
        self.result = []
        self.currPath = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.checkSum(root, targetSum, 0)
        return self.result

    def checkSum(self, root: Optional[TreeNode], targetSum: int, currSum: int) -> None:
        if root == None: return
        self.currPath.append(root.val)
        if root.left == None and root.right == None:
            currSum += root.val
            if currSum == targetSum:
                self.result.append(copy.deepcopy(self.currPath))
                self.currPath.pop(-1)
                return
        
        self.checkSum(root.left, targetSum, currSum + root.val)
        self.checkSum(root.right, targetSum, currSum + root.val)
        self.currPath.pop(-1)

