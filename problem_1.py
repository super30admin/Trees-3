# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res=[]
        if not root: return []
        self.dfs(root, [], 0, targetSum)
        return self.res
        
    def dfs(self, root, lst, val, targetSum):
        if not root: return
        val= val+root.val
        lst.append(root.val)
        if not root.left and not root.right:
            if val==targetSum: 
                self.res.append(lst.copy())
                
        self.dfs(root.left, lst, val, targetSum)
        self.dfs(root.right, lst, val, targetSum)
        lst.pop()
            