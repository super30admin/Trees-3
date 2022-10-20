#Time -> O(n)
#Space -> O(h) 


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
        
        def dfs(root,my_sum,lst,res):
            if root.left==None and root.right==None:
                if root.val==my_sum:
                    res+=[lst+[root.val]]
            
            if root.left:
                dfs(root.left,my_sum-root.val,lst+[root.val],res)
            
            if root.right:
                dfs(root.right,my_sum-root.val,lst+[root.val],res)
                
            return res
                
        
        return dfs(root,targetSum,[],[])