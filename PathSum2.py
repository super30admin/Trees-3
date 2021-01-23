# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        '''
        Algorithm - Made the choice
                    Explore the path
                    Undo the choice
                    
        Time Complexity - O(N)
        Space Complexity - O(N) Implicit Stack
        '''
        self.output=[] # For final output
        
        self.helper(root,targetSum,[])
        
        return self.output
    
    def helper(self,root,targetSum,res):
        
        if root == None:
            return 
        
        # Make the selection
        res.append(root.val)
        
        # Check the condition
        if root.left == None and root.right == None and sum(res)== targetSum:
            self.output.append(res[:])
            
        #Backtrack
        self.helper(root.left,targetSum,res)
        self.helper(root.right,targetSum,res)
        #Undo the selection
        res.pop()
            