#time O(N)
#space O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        pathl=[]
        
        def dfs(root,p,paths,pathl):
            if not root:
                return 
            if root.val==p and not root.left and not root.right:
                paths.append(root.val)
                pathl.append(list(paths))
            else:
                dfs(root.left,p-root.val,paths+[root.val],pathl)
                dfs(root.right,p-root.val,paths+[root.val],pathl)
        dfs(root,targetSum,[],pathl)
        
        return(pathl)
        