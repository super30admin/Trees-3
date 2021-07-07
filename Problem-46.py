# leetcode: 113
# Time Complexity - O(N)
# Space complexity -O(N)



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        res=[]
        path=[]
        self.dfs(root,sum,res,path)
        return res
    
    def dfs(self,root,sum,res,path):
        if not root:
            return
        else:
            path.append(root.val)
        
        if (root.left == None and root.right == None and sum == root.val): 
            res.append(list(path))
            return
        
        if root.left:
            self.dfs(root.left,sum-root.val,res,path)
            path.pop()
        if root.right:
            self.dfs(root.right,sum-root.val,res,path)
            path.pop()
    