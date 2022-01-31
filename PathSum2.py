# Time complexity o(n2)
# Space Complexity o(n)




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.result = []
        self.target = 0
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        
        self.target = targetSum
        
        self.helper(root,0 ,path)
        
        return self.result

        
    def helper(self,root,sum,path):
#         Base condition
        if root == None:
            return
        
        sum += root.val
#  Action       
        path.append(root.val)
      
#       Recursion  
        self.helper(root.left , sum ,path)
                    
        if root.left == None and root.right == None:
            if sum == self.target :
                print(path)
                self.result.append(path.copy())
                    
                    
        # self.helper(root.left , sum ,path)

        self.helper(root.right , sum ,path)
#    BackTracking     
        path.pop()
        
        
        