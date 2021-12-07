#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res=[]
        if not root:
            return []
 #calculating sum and storing the path        
        def dfs(root,sum,path):
            if not root.left and not root.right and sum==targetSum:
               
                res.append(path)
                return
            
            if root.left:
                dfs(root.left,sum+root.left.val,path+[root.left.val])
                
            if root.right:
                dfs(root.right,sum+root.right.val,path+[root.right.val])
                
        dfs(root,root.val,[root.val])
        return res