#

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        def dfs(root,path,ans,remaingSum):
            if not root:
                return
            
            path.append(root.val)
            
            if not root.left and not root.right and remaingSum==root.val:
                ans.append(list(path))
                
            dfs(root.left,path,ans,remaingSum-root.val)
            dfs(root.right,path,ans,remaingSum-root.val)
            
            path.pop()
            
            
            
            
            
        ans=[]
        dfs(root,[],ans,targetSum)
        return ans