# Time O(N)
# Space O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        self.path = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        self.dfs(root, 0, targetSum)
        return self.result 
    
    def dfs(self, root, cur_sum, target):
        if not root:
            return 
        cur_sum += root.val
        self.path.append(root.val) 
        if not root.left and not root.right:
            if cur_sum == target:
                self.result.append(list(self.path))
        self.dfs(root.left, cur_sum, target)
        self.dfs(root.right, cur_sum, target)
        self.path.pop()

        