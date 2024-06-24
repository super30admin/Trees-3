"""
Trees-3
Problem1 (https://leetcode.com/problems/path-sum-ii/)

Time Complexity : O(n+h) ~ O(n)
Space Complexity : O(h) where h in worst case is all nodes in tree. 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Backtracking - Action Recurse Backtrack
Trick is to calculate current sum and push each node to the current path and when we reach the leaf node we check if the current
sum is equal to the target sum and if yes we create a copy of that list & push it to the result since we're using same reference
to generate all the results so it can be corrupted. Also we should be making sure that we pop the current node when we complete
the left and right sub tree recursions.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(root, curr_sum, path):
            if root is None:
                return 

            curr_sum += root.val
            path.append(root.val)

            if root.left is None and root.right is None:
                if curr_sum == targetSum:
                    self.result_paths.append(list(path)) # you should not return since pop should happen
            
            dfs(root.left, curr_sum, path)
            dfs(root.right, curr_sum, path)
            path.pop()


        if root is None:
            return []
        self.result_paths = []
        dfs(root, 0, [])
        return self.result_paths


        
