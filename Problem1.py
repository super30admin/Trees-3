# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(root,sum,path,result):
            if not root:
                return
            if not root.left and not root.right and sum==root.val:
                path.append(root.val)
                result.append(path)
            
            dfs(root.left,sum-root.val,path + [root.val],result)
            dfs(root.right,sum-root.val,path + [root.val],result)
        
        res= []
        dfs(root, targetSum,[],res)
        return res
