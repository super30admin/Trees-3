# time complexity is O(N) and space complexity is O(N)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        
        res = []
        self.dfs(root, targetSum, [], res)
        return res
    
    def dfs(self, root, targetSum, tempSum, res):
        if root:
            if not root.left and not root.right and targetSum==root.val:
                tempSum.append(root.val)
                res.append(tempSum)
                
            self.dfs(root.left, targetSum-root.val , tempSum+[root.val], res)
            self.dfs(root.right, targetSum-root.val , tempSum+[root.val], res)