// Time Complexity : O(n) 
// Space Complexity : O(n+h) 
                     //list of elements pathSum
                    //recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result=[]
        if root == None:
            return self.result
        self.traverse(root,'',targetSum)
        return self.result
    
    
    def traverse(self,node,s,target):
        if node.val!=None:
            s=s+","+str(node.val)
        
        
        if node.left == None and node.right==None:
            v=[]
            for i in s.split(","):
                try:
                    v.append(int(i))
                except:
                    pass
                
            if sum(v)==target:
                self.result.append(v)
        
        
        if node.left!=None:
            self.traverse(node.left,s,target)
            
        if node.right!=None:
            self.traverse(node.right,s,target)    