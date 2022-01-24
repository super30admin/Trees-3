#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    final = [] 
    target =0
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if(root==None):
            return []
        self.final = []
        self.target = targetSum
        self.helper(root,0,[])
        return self.final
        
    def helper(self,root,curr,path):
        if(root==None):
            return 
        curr+=root.val
        path.append(root.val)
        if(root.left==None and root.right==None):
            if(self.target==curr):
                self.final.append([i for i in path])
        
        self.helper(root.left,curr,path)
        self.helper(root.right,curr,path)
        path.pop(-1)
        
            