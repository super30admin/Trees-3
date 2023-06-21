# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res=[]
        self.helper(root, 0, targetSum, [], res)
        return res
        
    def helper(self, root, s, t, pt, res):
        if(root==None):
            return
        
        s+=root.val
        #nL=list(pt)
        #nL.append(root.val)
        pt.append(root.val)
        if(root.left == None and root.right == None):
            if(s==t):
                nl=list(pt)
                res.append(nl)
        
        self.helper(root.left, s, t, pt, res)
        self.helper(root.right, s, t, pt, res)
        pt.pop()
        
