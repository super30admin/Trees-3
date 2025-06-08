# Time Complexity : O(N * H), where N is number of nodes and H is tree height
# Space Complexity : O(H) for recursion stack and path storage, plus O(N * H) for result paths in worst case
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        res = []

        def dfs(node, curr_sum, path):
            if node is None:
                return
            
            path.append(node.val)
            curr_sum += node.val
            
            # Check if leaf node and sum matches targetSum
            if node.left is None and node.right is None:
                if curr_sum == targetSum:
                    res.append(path[:])  # Append a copy of path
            
            # Recurse left and right
            dfs(node.left, curr_sum, path)
            dfs(node.right, curr_sum, path)
            
            path.pop()  # Backtracking to remove current node before returning

        dfs(root, 0, [])
        return res


    # -------------------------------------------------------
    # Naive Approach
    # Instead of keeping running sum, sum path every time at leaf node (less optimal)
    #
    # Time Complexity : O(N * H)
    # Space Complexity : O(H)
    #
    # res = []
    #
    # def dfs(node, path):
    #     if node is None:
    #         return
    #
    #     path.append(node.val)
    #
    #     if node.left is None and node.right is None:
    #         if sum(path) == targetSum:
    #             res.append(path[:])
    #
    #     dfs(node.left, path)
    #     dfs(node.right, path)
    #
    #     path.pop()
    #
    # dfs(root, [])
    # return res
