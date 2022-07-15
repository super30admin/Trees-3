# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        l=[]
        path=[]
        def path_sum(root,target):
            if root is None:
                return
            
            path.append(root.val) 
            
            if root.left is None and root.right is None:
                if root.val==target:
                    l.append(path[:])
            
            path_sum(root.left,target-root.val)
            path_sum(root.right,target-root.val)
            
            path.pop()
            
        path_sum(root,targetSum)
        
        return l
        