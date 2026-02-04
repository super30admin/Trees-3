''' 
Time Complexity : O(n*h) 
Space Complexity : O(n*h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

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
        # base
        if root == None:
            return

        #logic
        currSum += root.val
        path.append(root.val)
        #action
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(list(path))
        
        # recursion
        self.helper(root.left, currSum, targetSum, path)
        self.helper(root.right, currSum, targetSum, path)


        #backtracking
        path.pop(-1)

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return self.result
        self.helper(root, 0, targetSum, [])

        return self.result
        