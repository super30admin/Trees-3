# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#-------------------------------Create new list using deep copy-------------------------------
# Time = O(n*h), h = height of tree, Space = O(h)-> for stack + O(n*h) ->at every node we have to copy h elements to new list, n = total nodes
# class Solution:
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         self.result = []
#         self.dfs(root, 0, [], targetSum)
#         return self.result

#     def dfs(self, root: Optional[TreeNode], currSum: int, path:List[int], targetSum: int) -> None:
#         # base case
#         if root ==  None:
#             return
#         # logic
#         currSum = currSum + root.val
#         path.append(root.val)
#         if root.left == None and root.right == None:
#             if currSum == targetSum:
#                 self.result.append(path)
#         self.dfs(root.left, currSum, [i for i in path], targetSum)
#         self.dfs(root.right, currSum, [i for i in path], targetSum)

#---------------------Using Backtracking-----------------------------------------------
# Time = O(n), Space = O(h) -> for stack + O(h) -> for storing list = O(2h) 
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.dfs(root, 0, [], targetSum)
        return self.result

    def dfs(self, root: Optional[TreeNode], currSum: int, path:List[int], targetSum: int) -> None:
        # base case
        if root == None:
            return
        # logic
        # action
        currSum = currSum + root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append([i for i in path])
        self.dfs(root.left, currSum, path, targetSum)
        self.dfs(root.right, currSum, path, targetSum)
        # backtrack
        path.pop()