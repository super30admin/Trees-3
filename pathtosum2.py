# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
// Time Complexity : O(N) - > visit every node
// Space Complexity : O(N) - > stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def pathSum(self, root, sum):
        
        self.result = []
        self.dfs(root, sum, [])
        return self.result
    
    def dfs(self, root, rsum, stack):
        
        if not root:
            return
        
        stack.append(root.val)
        if root.left is None and root.right is None:                
            if rsum == root.val:
                self.result.append(list(stack))
                    
        self.dfs(root.left, rsum - root.val, stack)        
        self.dfs(root.right, rsum - root.val, stack)
        
        stack.pop()
        
        
