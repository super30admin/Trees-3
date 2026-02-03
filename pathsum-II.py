class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result=[]
        self.helper(root,targetSum,0,[])
        return self.result



    def helper(self, root, targetSum,currsum,path):

        if root==None:
            return
        
        currsum=currsum+root.val
        path.append(root.val)
        if root.left==None and root.right==None:
            if currsum==targetSum:
                self.result.append(list(path))
        
        self.helper(root.left,targetSum,currsum,path)
        self.helper(root.right,targetSum,currsum,path)

        path.pop()