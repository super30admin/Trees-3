# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def helper(self, root: TreeNode, targetSum: int, lst: list[int], result: [[int]]) -> list[list[int]]:
        
        if root.left == None and root.right == None:
            if root.val == targetSum:
                #dic.get(i).append(add)
                #i = i + 1
                result += [lst + [root.val]] 
                    
                
            
        if root.left != None:
            
            self.helper(root.left, targetSum - root.val, lst + [root.val], result)
            
        if root.right != None:
            
            self.helper(root.right, targetSum - root.val, lst+ [root.val],result)
        
        return result
        
        
            
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        if root == None:
            
            return None
        
                
       
        
        add = 0
        arr = []
        
        
        return self.helper(root, targetSum,[],[])
        
        
        