#TC - O(N^2)
#SC - O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfs(root,path,res,target):
            if not root:
                return 
            path.append(root.val)
            if root.val == target and not root.left and not root.right:
                res.append(list(path))
            dfs(root.left,path,res,target-root.val)
            dfs(root.right,path,res,target-root.val)
            path.pop()
        res =[]
        dfs(root,[],res,targetSum)
        return res
            