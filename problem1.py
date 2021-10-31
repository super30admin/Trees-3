#Time complexity O(n) and space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res=[]
        if not root:
            return []
 #calculating sum and storing the path        
        def helper(root,sum,path):
            if not root.left and not root.right and sum==targetSum:
               
                res.append(path)
                return
            
            if root.left:
                helper(root.left,sum+root.left.val,path+[root.left.val])
                
            if root.right:
                helper(root.right,sum+root.right.val,path+[root.right.val])
                
        helper(root,root.val,[root.val])
        return res
