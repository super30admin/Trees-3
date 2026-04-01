# Time Complexity : O(n * h) where h = height of tree
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use DFS with backtracking.
# Traverse the tree while maintaining current path and sum.
# Add current node value to path and update running sum.
# If a leaf node is reached and sum equals target, store the path.
# Backtrack by removing the last element before returning to previous call.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        def helper(r,arr,c_sum):
            if r is None:
                return 
            arr.append(r.val)
            c_sum += r.val
            helper(r.left,arr,c_sum)
            helper(r.right,arr,c_sum)
            if r.left is None and r.right is None:
                if c_sum == targetSum:
                    res.append(arr[:])
            arr.pop()

        res = []
        helper(root,[],0)
        return res