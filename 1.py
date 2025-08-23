'''
Trees-3

Problem1 (https://leetcode.com/problems/path-sum-ii/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]: # type: ignore
        if root == None:
            return []
        self.result = []
        self.helper(root, 0, [], targetSum) #[5,0,[],22]
        return self.result

    def helper(self, root: Optional[TreeNode], currSum: int, path:List[int], targetSum): # type: ignore
        if root == None:
            return

        #logic
        #action
        currSum = currSum + root.val #18
        path.append(root.val) #[5] * 420
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append([i for i in path])
        #recurse
        self.helper(root.left, currSum, path, targetSum)
        self.helper(root.right, currSum, path, targetSum)

        #backtrack
        path.pop()       
