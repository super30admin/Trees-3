# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.target = targetSum
        result = []
        self.final = []
        csum = 0
        if (root == None):
            return []
        self.helper(root,result,csum)
        return self.final
        
        
    
    def helper(self, root,result, csum):
        if(root == None):
            return
        result.append(root.val)
        csum = csum + root.val

        if(root.left == None and root.right ==None):
            if(csum == self.target):
                self.final.append(result.copy())
            result.pop()
            return
        
        self.helper(root.left,result,csum)
        self.helper(root.right,result,csum)
        result.pop()
        

        