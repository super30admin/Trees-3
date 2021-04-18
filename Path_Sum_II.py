# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    result = []
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        if not root:
            return Solution.result
        
        self.helper(root,targetSum,0,[])    
        #self.backtrack(root,targetSum,0,[])    
        
        return Solution.result
    
    def helper(self,root,targetsum,cursum,path):
        #Base
        if not root:
            return
            
        #Logic
        
        cursum = cursum + root.val
        path.append(root.val)
        
        if not root.left and not root.right:
            if targetsum == cursum:
                Solution.result.append(path)
        
        self.helper(root.left,targetsum,cursum,path.copy())    
        self.helper(root.right,targetsum,cursum,path.copy())    
        
    def backtrack(self,root,targetsum,cursum,path):
        #Base
        if not root:
            return
            
        #Logic
        
        cursum = cursum + root.val
        path.append(root.val)
        
        if not root.left and not root.right:
            if targetsum == cursum:
                Solution.result.append(path.copy())
        
        self.backtrack(root.left,targetsum,cursum,path)    
        self.backtrack(root.right,targetsum,cursum,path)    
        
        path.pop()
        
