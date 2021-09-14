# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        result = []
        def dfs( root, targetSum, path):#, result):
            
            # Base
            if root is None:
                re = list(result)
                return re
            path.append(root.val)
            
            # Action\logic
            if root.left is None and root.right is None:
                if(targetSum - root.val == 0):
                    
                    # Storing the path, as the path latter becomes
                    # empty while backtracking
                    newpath = list(path)
                    
                    result.append(newpath)
            
            # Recursion
            dfs(root.left, targetSum - root.val, path)#, result)
            dfs(root.right, targetSum  - root.val, path )#, result)
            
            # backtrack
            path.pop()
        dfs(root, targetSum, [])#, result)
        return result
