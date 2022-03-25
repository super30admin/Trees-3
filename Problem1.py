# Time Complexity : O(N*N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        ans = []
        sum_val = targetSum
        self.dfs(root, sum_val, [],ans)
        return ans

    def dfs(self, root, sum_val, tmp, ans):
        if not root:
            return
        if root.left == None and root.right == None and sum_val == root.val:
            ans.append(tmp+[root.val])
            return
        self.dfs(root.left, sum_val - root.val, tmp+[root.val], ans)
        self.dfs(root.right, sum_val - root.val, tmp+[root.val], ans)
