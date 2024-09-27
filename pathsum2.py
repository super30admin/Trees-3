# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






import copy
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result=[]
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        summ=0
        res=[]
        self.inorder(root,summ,targetSum,res)
        return self.result
    def inorder(self,root,summ,targetSum,res):
        if not root:
            return
        else:
            
            res.append(root.val)
            print(res)
            #action
            if not root.left and not root.right:
                
                summ=summ+root.val
                
                if summ==targetSum:
                    new=copy.deepcopy(res)
                    self.result.append(new)
                    
                    
#                 res.remove(root.val)
            #recursion
            self.inorder(root.left,summ+root.val,targetSum,res)
            self.inorder(root.right,summ+root.val,targetSum,res)
            #backtracing
            res.pop()
        