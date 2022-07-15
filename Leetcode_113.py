
class Solution:
    def pathSum(self, root, targetSum: int):
        ans=[]
        def dfs(root,path):
            if not root:
                return
            path=path+[root.val]
            if root.left is None and root.right is None:
                ans.append(path)
            dfs(root.left,path)
            dfs(root.right,path)
        dfs(root,[])
        res=0
        for listofnum in ans:
            k=len(listofnum)
            for i in range(k):
                res+=10**(k-1-i)*listofnum[i]
        return res