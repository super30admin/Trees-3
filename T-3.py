# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0, [], targetSum)
        return self.result
    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int) -> None:
        #base
        if root == None:
            return
        #Logic
        #Action
        path.append(root.val)
        currSum = currSum + root.val
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append([i for i in path])
            #return
        #recurse
        self.dfs(root.left, currSum, path, targetSum)
        self.dfs(root.right, currSum, path, targetSum)
        #backtrack
        path.pop()
#TC = O(n), SC = O(n)

## Problem2 (https://leetcode.com/problems/symmetric-tree/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.dfs(root.left, root.right)
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
        if left == None and right == None:
            return True
        if left == None or right == None:
            return False
        if left.val != right.val:
            return False
        case1 = self.dfs(left.left, right.right)
        case2 = self.dfs(left.right, right.left)
        return case1 and case2
# TC= O(n), SC = O(n)       
