"""
TC = O(N)  SC = O(H) where H = height of tree and N = Number of nodes. Because the data structure used to hold the result is not considered in SC
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        self.target = targetSum
        if root != None:
            self.dfs(root, 0, [])
        return self.result

    def dfs(self, root, sumSoFar, path):
        if root == None:
            return
        sumSoFar += root.val
        path.append(root.val)
        if root.left == None and root.right == None and sumSoFar == self.target:
            self.result.append(copy.deepcopy(path))
        self.dfs(root.left, sumSoFar, path)
        self.dfs(root.right, sumSoFar, path)
        path.pop()