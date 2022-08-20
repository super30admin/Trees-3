'''
Time Complexity - O(n)
Space Complexity - O(h)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        self.path = []
        self.dfs(root, 0, targetSum)
        return self.res

    def dfs(self, root, currSum, targetSum):
        if root == None:
            return
        currSum += root.val
        self.path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.res.append(list(self.path))

        self.dfs(root.left, currSum, targetSum)
        self.dfs(root.right, currSum, targetSum)
        self.path.pop()
