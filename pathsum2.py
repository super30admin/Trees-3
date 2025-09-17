# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(N h) where h is the recursion stack space maximum height of the tree and N is if all nodes are leaf nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a depth-first search (DFS) approach to find all root-to-leaf paths in the binary tree.
# I maintain a running sum of the node values along the current path and a list to store the current path.
# When I reach a leaf node, I check if the running sum equals the target sum.
# If it does, I add a copy of the current path to the result list.
# I use backtracking to explore all possible paths by removing the last node from the path after exploring both subtrees.

from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        
        def dfs(root,sumy,path):
            if not root:
                return 
            sumy += root.val
            path.append(root.val)
            if not root.left and not root.right and sumy == targetSum:
                result.append(path[:])
            dfs(root.left,sumy,path)
            dfs(root.right,sumy,path)
            path.pop()
        dfs(root,0,[])
        return result
        
            
        