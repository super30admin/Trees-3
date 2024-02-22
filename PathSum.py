'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        self.flag = False

        def helper(root, currSum):
            if not root or self.flag == True:
                return 
            currSum += root.val
            if (not root.left and not root.right) and (currSum == targetSum):
                self.flag = True
            helper(root.left, currSum)
            helper(root.right, currSum)

        helper(root, 0)
        return self.flag