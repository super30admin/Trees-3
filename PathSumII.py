# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []
        if not root.left and not root.right and root.val==targetSum:
            return [[root.val]]
        result = []
        def dfs(root,path,currsum):
            nonlocal result
            if not root:
                return
            if not root.left and not root.right and currsum+root.val==targetSum:
                path.append(root.val)
                result.append(path.copy())
                path.pop()
                return
            path.append(root.val)
            
            dfs(root.left,path,currsum+root.val)
            dfs(root.right,path,currsum+root.val)
            path.pop()
            

        dfs(root,[],0)
        return result
        