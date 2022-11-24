# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        ## T.C = O(n)
        ## S.C = O(h)
        
        ## DFS with backtracking
        res = []
        
        def dfs(root, path_nums):

            if not root:
                return
            
            path_nums.append(root.val)
            if not root.left and not root.right:
                if sum(path_nums) == targetSum:
                    res.append(list(path_nums))
                
            dfs(root.left, path_nums)
            dfs(root.right, path_nums)
            
            #back track
            path_nums.pop()
        
        dfs(root, [])
        
        return res
        
        ###############################################
        ## DFS with new list creation in each iteration
        
        res = []
        
        def dfs(root, path_nums):
            if not root:
                return
            
            tmp = list(path_nums)
            tmp.append(root.val)
            if root.left is None and root.right is None:
                if sum(tmp) == targetSum:
                    res.append(tmp)
                return
            
            dfs(root.left, tmp)
            dfs(root.right, tmp)
            
        
        dfs(root, [])
        return res
        