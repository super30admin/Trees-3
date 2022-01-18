# Recursive Preorder
# // Time Complexity : O(2^N)
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    target = 0
    result = list()
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = [] #everytime initialize and empty list
        self.target = targetSum
        self.helper(root, 0, list())
        return self.result
        
    def helper(self, root, currSum, path):
        # base
        if(root == None):
            return
        # logic
        currSum += root.val
        path.append(root.val)
        self.helper(root.left, currSum,list(path)) #everytime add a new list to the node
        if root.left == None and root.right == None:
            if currSum == self.target:
                self.result.append(path)
        self.helper(root.right,currSum,list(path)) #everytime add a new list to the node
        
        